<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
 <title>Добро пожаловать</title>
 <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <style>
    <%@include file='../css/style.css' %>
 </style>
</head>
<body>
    <h1>My ToDo List</h1>
    <form id="mainForm" method="POST">
        <input type="submit" id="bfnl" value="New List"">
    </form>
    <div id = "mainDiv">

    </div>
	</form>
</body>
</html>