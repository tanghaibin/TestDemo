<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=CK1XurNTAzmyNSLAGHIYEfx2"></script>
    <title>浏览器定位</title>
</head>
<body>

<script type="text/javascript">

    // 用经纬度设置地图中心点
    function theLocation(jd,wd){
        var lng = null;
        var lat = null;
        // 百度地图API功能
        var map = new BMap.Map("allmap");
        var point = new BMap.Point(116.331398,39.897445);
        map.centerAndZoom(point,12);

        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
                lng = r.point.lng;
                lat = r.point.lat;

               // map.centerAndZoom(new BMap.Point(lng,lat), 11);

                var p1 = new BMap.Point(lng,lat);
                var p2 = new BMap.Point(jd,wd);

                var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
                driving.search(p1, p2);
                //alert('您的位置：'+r.point.lng+','+r.point.lat);
            }
            else {
                alert('failed'+this.getStatus());
            }
        },{enableHighAccuracy: true})



    }

    //获取点击的坐标
    function toLocation(obj){
        var local = obj.innerText;
        var arry = local.split(",");
        theLocation(arry[0],arry[1]);
    }

</script>
葛仙山坐标点：<label id="label1" onclick="toLocation(this)">103.952833,31.179563</label><br/>
丹景山坐标点：<label id="label2" onclick="toLocation(this)">103.850342,31.094941</label><br/>
龙门山坐标点：<label id="label3" onclick="toLocation(this)">103.883089,31.321973</label><br/>
龙门山镇坐标点：<label id="label4" onclick="toLocation(this)">103.784799,31.234517</label><br/>
白鹿镇坐标点：<label id="label5" onclick="toLocation(this)">103.920705,31.210055</label><br/>
彭州博物馆坐标点：<label id="label6" onclick="toLocation(this)">103.935336,30.994024</label><br/>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">



    //关于状态码
    //BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
    //BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
    //BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
    //BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
    //BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
    //BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
    //BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
    //BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
    //BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)



</script>
