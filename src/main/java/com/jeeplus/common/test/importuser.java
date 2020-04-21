package com.jeeplus.common.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jeeplus.common.security.Digests;
import com.jeeplus.common.utils.Encodes;
import com.jeeplus.common.utils.PingYinUtil;

public class importuser {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    public static final String URL = "jdbc:mysql://222.184.79.92:8307/jszh"; 
    public static final String USERNAME = "root"; 
    public static final String PASSWORD = "Hazte!123"; 
    public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	public static void main(String[] args) throws Exception {
		/*PingYinUtil py = new PingYinUtil();
		String ss = py.getFirstSpell("你好");
		System.out.println(ss);  */
		 test1();
    }
	
	public static void test1() throws Exception 
    { 
        Class.forName(DRIVER_CLASS); 
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        
        Statement statement=connection.createStatement();  
        //查询数据,其中输入sql语句  
        ResultSet rSet=statement.executeQuery("select id, name from sys_user where name ='admin' ");  
                 //rSet.next()返回的是一个布尔类型的值，而且将指针指向下一条记录  
        while(rSet.next()){  
            String id = rSet.getString("id");
            String name = rSet.getString("name");
            PingYinUtil py = new PingYinUtil();
            String cname = py.getFirstSpell(name);
            
            Statement sta=connection.createStatement(); 
            
            String pass = entryptPassword("123");
            
            String sql=" update sys_user set password = '" + pass +"' ,login_name = '" + cname +"' , no = '" + cname +"'  where id= '" + id +"'";  
//            statement.executeUpdate(sql);
            
            try {
            	sta.executeUpdate(sql);
            	sta.close();
                System.out.println("数据更新成功!");
            }catch (Exception e) {
                System.out.println("数据更新失败!" +e.getMessage());
            }
            
           // System.out.println(result);  
           
        }
        statement.close();
        connection.close(); 
    } 
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
}
