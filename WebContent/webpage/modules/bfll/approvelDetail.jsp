<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<html>
<head>
    <title>审批详情</title>
    <meta name="decorator" content="default"/>

    <style type="text/css">
        .tableEdit {
            border-top: 1px solid #EEE;
            width: 100%;
            padding: 0;
            margin: 0;
            margin-bottom: 10px;
        }

        .fonSiz {
            font-size: 12px;
            font-weight: bold;
        }

        tr {
            border-left: 1px solid #EEE;
        }

        td {
            border-right: 1px solid #EEE;
            border-bottom: 1px solid #EEE;
            background: #fff;
            font-size: 14px;
            padding: 6px 6px 6px 12px;
            color: #4f6b72;
        }

        .input-xlarge {
            width: 96%;
            height: 30px;
            border: 1px solid #e3e6f3;
        }

        .input-jbxx {
            width: 10%;
            height: 28px;
            border: 1px solid #e3e6f3;
            margin-right: 5px;
        }

        .col-red {
            padding-top: 20px;
            color: red;
        }

        .jtcy-th {
            border: 0px;
        }

        .jtcy-th th {
            padding: 5px;
            text-align: center;
            border-left: 1px solid #e3e6f3;
            border-right: 1px solid #e3e6f3;
            border-bottom: 1px solid #e3e6f3;
        }
    </style>
    <script type="text/javascript">

    </script>
</head>
<body>
<ul class="nav nav-tabs">
</ul>
<br/>

<table class="tableEdit">
    <tr>
        <td colspan="10" class="fonSiz">审批详情</td>
    </tr>
    <tr>
        <td align="right" width="15%">申请人：</td>
        <td width="35%">${approvelDetail.name }</td>
        <td align="right" width="15%">所属村：</td>
        <td width="35%">${approvelDetail.country}</td>

    </tr>
    <tr>
        <td align="right" width="15%">所属组：</td>
        <td width="35%">${approvelDetail.groupName }</td>

        <td align="right" width="15%">创建日期：</td>
        <td width="35%">${approvelDetail.createDate }</td>
    </tr>
    <tr>
        <td align="right" width="15%">备注：</td>
        <td width="35%">${approvelDetail.remarks }</td>
        <td align="right" width="15%">审批状况：</td>
        <td width="35%">
            <c:if test="${approvelDetail.status == 1}">
                通过
            </c:if>
            <c:if test="${approvelDetail.status == 2}">
                通过
            </c:if>
            <c:if test="${approvelDetail.status == 0}">
                未通过
            </c:if>
        </td>
    </tr>

</table>


</body>
</html>