<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script>
    function delete_ok(id) {
        var a = confirm("정말로 삭제하겠습니까?");
        if(a) location.href='deleteok/' + id;
    }
</script>

<head>
    <title>Life Quotes</title>
</head>
<body>
<h1>Life Quotes List</h1>
<table id="list" width="90%" border="1">
    <tr>
        <th>Seq</th>
        <th>Tag</th>
        <th>Writer</th>
        <th>Content</th>
        <th>Birthdate</th>
        <th>Country</th>
        <th>Gender</th>
        <th>Regdate</th>
        <th>Edit</th>
        <th>View</th>
        <th>Delete</th>


    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.seq}</td>
            <td>${u.tag}</td>
            <td>${u.writer}</td>
            <td>${u.content}</td>
            <td>${u.birthdate}</td>
            <td>${u.country}</td>
            <td>${u.gender}</td>
            <td>${u.regdate}</td>

            <td><a href="editform/${u.seq}">Edit</a></td>
            <td><a href="viewform/${u.seq}">View</a></td>
            <td><a href="javascript:delete_ok('${u.seq}')">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br/><button type="button" onclick="location.href='add'">ADD</button>
</body>
</html>
