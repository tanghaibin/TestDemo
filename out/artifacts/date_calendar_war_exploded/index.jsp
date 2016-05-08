
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Custom Calendar - jQuery EasyUI Demo</title>
  <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="css/demo.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<div style="margin:20px 0"></div>
  <div style="margin:20px 0"></div>
  <div class="easyui-calendar" style="margin-left:130px;width:80%;height:500px;" data-options="formatter:formatDay"></div>
<script>

  function add(date){
    alert(new Date(date).toLocaleDateString());
  }

  function find(date){
    alert(new Date(date).toLocaleDateString());
  }


  var d1 = Math.floor((Math.random()*30)+1);
  var d2 = Math.floor((Math.random()*30)+1);
  function formatDay(date){
    var m = date.getMonth()+1;
    var d = date.getDate();
    var opts = $(this).calendar('options');
    var nowtimestamp=new Date().getTime();
    var timestamp=new Date(date).getTime();
    if(timestamp <nowtimestamp){
      var str = "<br/><a href='javascript:void(0);' onclick='find(\""+date+"\")' class='easyui-linkbutton l-btn l-btn-small easyui-fluid' data-options='iconCls:'icon-search'' style='width: 80px;' group='' id=''><span class='l-btn-left l-btn-icon-left' style='margin-top: 0px;'><span class='l-btn-text'>查看</span><span class='l-btn-icon icon-search'>&nbsp;</span></span></a>";
      return d + str;
    }else{
      var str = "<br/><a href='javascript:void(0);' onclick='add(\""+date+"\")' class='easyui-linkbutton l-btn l-btn-small easyui-fluid' data-options='iconCls:'icon-add'' style='width: 80px;' group='' id=''><span class='l-btn-left l-btn-icon-left' style='margin-top: 0px;'><span class='l-btn-text'>添加</span><span class='l-btn-icon icon-add'>&nbsp;</span></span></a>";
      return d + str;
    }
  }


</script>
</body>
</html>

