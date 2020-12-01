<%-- 
    Document   : addReaderForm
    Created on : 01.12.2020, 14:31:37
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить читателя</title>
    </head>
    <body>
        <h1>Добавить читателя</h1>
        <form action="createReader" method="POST">
            Имя: <input type="text" name="name" value="${name}"><br>
            Фамилия: <input type="text" name="lastname" value="${lastname}"><br>
            Телефон: <input type="text" name="phone" value="${phone}"><br>
            <input type="submit" name="submit" value="отправить"><br>
        </form>
    </body>
</html>
