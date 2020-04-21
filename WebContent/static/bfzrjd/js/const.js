//var baseColor = ['#036eb7', '#6b0707', '#009844', '#e95513', '#8dc21f', '#6AB0B8', '#E98F6F', '#9FDABF', '#7FAE90'];

var baseColor = [ '#036eb7', '#6AB0B8', '#009844', '#e95513', '#8dc21f', '#E98F6F', '#9FDABF', '#7FAE90', '#6b0707' ];

var qxCode = {};
var qxLKKCode = {};
var xzCodeShift = {};
var qxLKKBackCode = {};
var qxBackCode = {};
for ( var key in XZCODE) {
	var value = XZCODE[key];
	if (XQNAME.indexOf(value) != -1) {
		qxCode[value] = key;
		qxLKKCode[value] = key;
		qxLKKBackCode[key] = value;
		qxBackCode[key] = value;
	}
	if(value == '全市'){
		continue;
	}
	xzCodeShift[value] = key;
}
qxCode['全市'] = shijiCode[0];
qxLKKCode['全市'] = shijiCode[1];
xzCodeShift['全市'] = shijiCode[0];
qxLKKBackCode[shijiCode[1]] = '全市';
qxBackCode[shijiCode[0]] = '全市';


var xzCode = XZCODE;
var pkcMap = PKC_COORDINATE;
var geoCoordMap = XZ_COORDINATE;



var mapArea = '全市';
var param_ADDRESS = GetQueryString('address');
var PKCNOWAREA = xzCode[param_ADDRESS] ? xzCode[param_ADDRESS] : '全市';
var NOWAREA = xzCode[param_ADDRESS];

var xzCode = XZCODE;
var NOWAREA = XQNAME[0];
