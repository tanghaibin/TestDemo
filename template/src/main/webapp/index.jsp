<%@page pageEncoding="utf-8"%>
<%@include file="/context/context.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>联系我们_（自适应手机版）响应式个人博客文章类网站织梦模板源码 - AB模板网 - Www.AdminBuy.Cn</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${ctx}/style/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <script src="${ctx}/style/js/jquery.min.js"></script>
    <script src="${ctx}/style/js/bootstrap.min.js"></script>
    <link href="${ctx}/style/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="${ctx}/style/js/jquery.easydropdown.js"></script>
    <link href="${ctx}/style/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="${ctx}/style/js/modernizr.custom.js"></script>
</head>
<body>
<div class="banner-bg two" id="home">
    <div class="container"> ﻿<div class="header">
        <div class="logo"> <a href="/"><FONT face="微软雅黑">
            <h1>AB模板网</h1>
            <span style="color: #011210"><span><strong><span style="color: #07128C; font-style: normal; font-size: 1.1em; text-align: left; font-family: '微软雅黑'; font-weight: 300;color: #f00">从此改变你的世界</span></strong></span></span></a> </div>
        <div class="top-nav">
            <label class="mobile_menu" for="mobile_menu"> <span>Menu</span> </label>
            <input id="mobile_menu" type="checkbox">
            <ul class="nav">
                <li><a class="now_" href="${ctx}/index.jsp">首页</a></li>

                <li><a  class="now_1" href="${ctx}/about.jsp">我的故事</a></li>

                <li><a  class="now_2" href="${ctx}/share/">分享足迹</a></li>

                <li><a  class="now_3" href="/sysy/">碎言碎语</a></li>

                <li><a  class="now_4" href="/lx/">联系我们</a></li>

            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
        <style>
            .nav li .now_4{
                color: #00b29f !important;
            }
        <${ctx}/style>
    </div>
</div>
<!--/contact-section-->
<div class="contact">
    <div class="container">
        <h3 class="tittle">打个招呼吧</h3>
        <lable class="two"> </lable>
        <h3 class="sub-text">我很期待与同龄人的交流。你的留言会被发布在我博客的留言板上，我会在有空时尽快回复你。</h3>
        <div class="contact-content">
            <ul class="contact-grids">
                <li class="contact-grid phone"> <i class="icon11"> </i>
                    <h4>电话</h4>
                    <h5>4008-888-888</h5>
                </li>
                <li class="contact-grid"> <i class="icon12"> </i> <a href="#">
                    <h4>电子邮箱</h4>
                </a>
                    <h5><a href="javascript:;">9490489@qq.com</a></h5>
                </li>
                <li class="contact-grid"> <i class="icon13"> </i> <a href="javascript:;">
                    <h4>QQ</h4>
                </a>
                    <h5>9490489</h5>
                </li>
                <div class="clearfix"> </div>
            </ul>
            <form action="/plus/diy.php" enctype="multipart/form-data" method="post">
                <input type="hidden" name="action" value="post" />
                <input type="hidden" name="diyid" value="1" />
                <input type="hidden" name="do" value="2" />
                <input type="text" class="textbox" name='xingming' id="xingming" placeholder="姓名">
                <input type="text" class="textbox" name='youxiang' id="youxiang" placeholder="邮箱">
                <div class="clearfix"> </div>
                <div>
                    <textarea name='neirong' id="neirong" placeholder="内容"></textarea>
                </div>
                <input type="hidden" name="dede_fields" value="xingming,text;youxiang,text;neirong,multitext" />
                <input type="hidden" name="dede_fieldshash" value="8eed8e23b5336876452b60f53981dec7" />
                <div class="submit">
                    <input type="submit" name="submit" id="tijiao" value="发送 " />
                </div>
            </form>
        </div>
        <iframe src="http://map.baidu.com/"> </iframe>
    </div>
</div>
﻿<!--/start-footer-section-->

<div class="footer-section">
    <div class="container">
        <div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
            <div class="col-md-4 footer-grid">
                <h4>关于我们</h4>
                <div class="border2"></div>
                <p>AB模板网是一家专业从事企业营销策划、电子商务运营服务的公司，主要业务包含精品网站制作、电子商务平台托管、百度竞价外包、 我们主要提供以下几点服务： a 淘宝开店与装修 b 网站建设 c 百度竞价外包 d 网络营销外包 1、以真心换真情，站在客户角度，客户的满意就是我们的追求，切实结合客户营销情况，制定营销方案。 2、团队网络营销实战经验丰富，可以规避很客户在</p>
            </div>
            <div class="col-md-4 footer-grid tweet">
                <h4>联系我</h4>
                <div class="border2"></div>
                <div class="icon-3-square"> <a href="javascript:;"><i class="square-3"></i></a>QQ:</div>
                <div class="icon-text">
                    <p>9490489</p>
                    <h5>&nbsp;</h5>
                </div>
                <div class="clearfix"></div>
                <div class="icon-3-square"> <a href="javascript:;"><i class="square-3"></i></a> 电话:</div>
                <div class="icon-text">
                    <p>4008-888-888<a href="javascript:;"></a></p>
                    <h5>&nbsp;</h5>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-4 footer-grid flickr">
                <h4>精彩影集</h4>
                <div class="border2"></div>
                <div class="flickr-grids"> <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/8.html"><img src="${ctx}/uploads/allimg/160801/1-160P114053OU.jpg" alt="珍珠被岩石滩瀑布"></a> </div>
                    <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/2.html"><img src="${ctx}/uploads/allimg/160801/1-160P1141020108.jpg" alt="珍珠滩瀑布"></a> </div>
                    <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/3.html"><img src="${ctx}/uploads/allimg/160801/1-160P1140933316.jpg" alt="草海秋色"></a> </div>
                    <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/4.html"><img src="${ctx}/uploads/allimg/160801/1-160P1140T4460.jpg" alt="平武山景"></a> </div>
                    <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/5.html"><img src="${ctx}/uploads/allimg/160801/1-160P1140P5L8.jpg" alt="在路上（九寨篇）"></a> </div>
                    <div class="flickr-grid"> <a href="${ctx}/share/2016/0704/6.html"><img src="${ctx}/uploads/allimg/160801/1-160P1140H61A.jpg" alt="五彩池"></a> </div>

                    <div class="clearfix"> </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//end-footer-section-->
<!--/start-copyright-section-->
<div class="copyright">
    <p>Copyright &copy; 2014-2016 Www.AdminBuy.Cn AB模板网 版权所有　<a href="http://www.adminbuy.cn">AB模板网</a></p>
</div>
<!--//end-copyright-section-->
<!--start-smoth-scrolling-->
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!--start-smoth-scrolling-->
<script type="text/javascript">
    $(document).ready(function() {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>