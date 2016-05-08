<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<shiro:hasPermission name="user:add">
    <input type="button" value="添加"/>
</shiro:hasPermission>
<shiro:hasPermission name="user:delete">
    <input type="button" value="删除"/>
</shiro:hasPermission>
<shiro:hasPermission name="user:edit">
    <input type="button" value="修改"/>
</shiro:hasPermission>
<h2>主界面</h2>
</body>
</html>
