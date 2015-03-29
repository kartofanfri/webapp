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
    <form:form method="POST">
        <form id="mainForm" method="POST">
            <form:input path="email"/>
            <form:input id="bfnl" path="id" value="Title for new List"/>
            <input type="text" id="bfnl" value="Title for new List">
            <input type="submit" id="bfnl" value="New List">
        </form>
    </form:form>
    <div id = "mainDiv">

       <c:forEach items="${lists}" var="list" varStatus="outerLoop">
           <form:form method="POST">
               <form id = "listNum${outerLoop.index}">
                   <div class="list">
                        <h1>Title</h1>
                        <c:forEach items="${list}" var="item" varStatus="loop">

                        <div class="itemList" class="buttonBlock">
                            <p id="itemNum${outerLoop.index}${loop.index}">${loop.index+1}) ${item}</p>
                            <div>
                            <input type="submit" class="addChItem" value="Del">
                            <input type="submit" class="addChItem" value="Ch">
                            </div>
                        </div>

                        </c:forEach>
                   </div>
               </form>
           </form:form>
       </c:forEach>

    </div>
	</form>
</body>
</html>