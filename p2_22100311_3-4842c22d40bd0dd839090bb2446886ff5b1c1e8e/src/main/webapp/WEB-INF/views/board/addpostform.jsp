<%--
  Created by IntelliJ IDEA.
  User: kwakdohyeon
  Date: 2023/12/01
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Quote</title>
</head>
<body>
<h1>Add New Quote</h1>
<form action="addok" method="post">
    <table id="edit">
        <tr><td>Tag</td><td><input type="text" name="tag" /></td></tr>
        <tr><td>Writer</td><td><input type="text" name="writer" /></td></tr>
        <tr><td>Content</td><td><input type="text" name="content" /></td></tr>
        <tr><td>Birthdate</td><td><input type="text" name="birthdate" /></td></tr>
        <tr><td>Country</td><td><input type="text" name="country" /></td></tr>
        <tr><td>Gender</td><td><input type="text" name="gender" /></td></tr>
        <tr><td>Regdate:</td><td><input type="text" name="regdate" value="<%= new java.util.Date() %>" readonly /></td>

    </table>


    <button type="submit">등록하기</button>
    <button type="button" onclick="location.href='list'">목록보기</button>
</form>
</body>
</html>