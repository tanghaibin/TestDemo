<%--
  Created by IntelliJ IDEA.
  User: tangh
  Date: 2016/11/12
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Hello MUI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <link rel="stylesheet" href="/css/mui.min.css">
</head>
<script src="/js/jquery.min.js"></script>
<script src="/js/mui.min.js"></script>
<script src="/js/initDom.js"></script>
<body>
<style type="text/css">
    #selectImg{
        width: 200px;
        height: 40px;
        background-color: blue;
        margin: 0 auto;
        margin-top: 50%;
        text-align: center;
        padding-top: 2%;
        color: white;
        font-family: '微软雅黑';
    }
</style>

<div id="selectImg">
    选择图片
</div>
</body>
<script type="text/javascript">
    mui.init();
    $("#selectImg").on('tap', function() {
            showActionSheet();
    });


    function showActionSheet() {
        var bts = [{
            title: "拍照"
        }, {
            title: "从相册选择"
        }];
        plus.nativeUI.actionSheet({
                    cancel: "取消",
                    buttons: bts
                },
                function(e) {
                    if (e.index == 1) {
                        getImage();
                    } else if (e.index == 2) {
                        galleryImgs();
                    }
                }
        );
    }
</script>
</html>