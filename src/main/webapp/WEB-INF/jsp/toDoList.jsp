<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form method="POST" action="todo.html">
        <input type="text" name="listTitle" value="Title for new List">
        <input type="submit" value="New List"/>
    </form:form>

    <div id = "mainDiv">

       <c:forEach items="${lists}" var="list" varStatus="outerLoop">
           <form:form method="POST" action="todo.html">
                   <div class="list">
                        <input type="hidden" name="ListNum" value=${outerLoop.index}${loop.index} />

                        <h1>${titles[outerLoop.index]}</h1>
                        <c:forEach items="${list}" var="item" varStatus="loop">

                        <div class="itemList" class="buttonBlock">
                            <p>${loop.index+1}) ${item}</p>
                            <input type="submit" name="chDel" class="addChItem" value="Del ${loop.index}">
                            <input type="submit" name="chDel" class="addChItem" value="Ch ${loop.index}">
                        </div>

                        </c:forEach>

                        <input type="text" class="newListTextBox" name="newListItem" value="New Item">
                        <input type="submit" class="addChItem" value="Add Item">
                   </div>
           </form:form>
       </c:forEach>

    </div>
	</form>
</body>
</html>