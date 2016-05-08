<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
        <form action="http://localhost:8084/user/login" method="post">

            <label>User</label>　<input type="text" name="username"/><br/><br/>
            <label>Pswd</label>　<input type="password" name="password"/><br/><br/>
            　&nbsp&nbsp&nbsp<input type="submit" />

        </form>

    <p><c:out value="${message}"/></p>
</body>
</html>
