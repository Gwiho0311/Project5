<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        img, label {
            display: inline-block;
        }

        label {
            width: 130px
        }

        button {
            background-color: blue;
            color: white;
            font-size: 15px;
            height: 20px;
        }
    </style>
    <script>
        function login_fail(id) {
            if (id == 0) {
                var a = confirm("로그인 실패");
            }
        }
    </script>
</head>
<body>
<div style='width:100%;text-align:center;padding-top:100px'>
    <script>login_fail(${login_f})</script>
    <img src='../img/x-mas.jpg' height="250">
    <form method="post" action="loginOk">
        <div>
            <label>User ID: </label>
            <input type='text' name='userid'/>
        </div>
        <div>
            <label>Password: </label>
            <input type='password' name='password'/>
        </div>
        <button type='submit'> login</button>
    </form>
</div>
</body>
</html>