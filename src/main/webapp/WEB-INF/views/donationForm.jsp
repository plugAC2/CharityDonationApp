<%--
  Created by IntelliJ IDEA.
  User: plugactwo
  Date: 16.05.2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Donate
<form:form method="POST" action="/donate" modelAttribute="donation">
    Choose a category:
    <form:checkboxes path="categories" items="${categories}" itemValue="id" itemLabel="name"/>
    <br>
    Choose an institution:
    <form:select path="institution" items="${institutions}" itemValue="id" itemLabel="name"/>
    <br>
    Street:
    <form:input path="street"/>
     City:
    <form:input path="city"/>
     Zip:
    <form:input path="zipCode"/>
    <br>
    Quantity of sacks:
    <form:input path="quantity"/>
    <br>
    <br>
    <div>
        Pick-up <br>
        Comment:
        <form:textarea path="pickUpComment"/>
         Date:
        <form:input type="date" path="pickUpDate"/>
         Time:
        <form:input type="time" path="pickUpTime"/>
    </div>
    <br>
    <input type="submit" value="Donate">
</form:form>
</body>
</html>
