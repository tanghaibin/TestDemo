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
<body>
<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <ul class="mui-table-view mui-table-view-chevron">

        </ul>
    </div>
</div>
</body>
<script type="text/javascript">

    var isNotMoreData = false;
    $(function () {
        mui.init({
            pullRefresh: {
                container: '#pullrefresh',
                down: {
                    callback: pulldownRefresh
                },
                up: {
                    contentrefresh: '正在加载...',
                    callback: pullupRefresh
                }
            }
        });

    });

    function optionEmptyDiv() {
        if ('${msg}' != '') {
            $("#empty-order-finish-div").css("display", "block");
            $("#finish-msg-p").html('${msg}');
        }
    }


    /**
     * 下拉刷新具体业务实现
     */
    function pulldownRefresh() {
        setTimeout(function () {
            var table = $("ul[class*='mui-table-view']");
            $.ajax({
                url: '/content',
                success: function (data) {
                    if(data.trim() == '') {
                        isNotMoreData = true;
                    }else {
                        isNotMoreData = false;
                    }
                    table.html(data);
                },
                error: function (e) {
                    alert(e);
                }
            });
            mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
        });
    }

    /**
     * 上拉加载具体业务实现
     */
    function pullupRefresh() {
        setTimeout(function () {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh(isNotMoreData); //参数为true代表没有更多数据了。
            var table = $("ul[class*='mui-table-view']");
            $.ajax({
                url: '/content',
                success: function (data) {
                    console.log(data.trim() == '');
                    if(data.trim() == '') {
                        isNotMoreData = true;
                        return;
                    }
                    table.append(data);
                },
                error: function (e) {
                    alert(e);
                }
            })
        });
    }
    if (mui.os.plus) {
        mui.plusReady(function () {
            setTimeout(function () {
                mui('#pullrefresh').pullRefresh().pullupLoading();
            }, 1000);

        });
    } else {
        mui.ready(function () {
            mui('#pullrefresh').pullRefresh().pullupLoading();
        });
    }
</script>
</html>