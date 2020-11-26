<%-- 
    Document   : addBookForm
    Created on : 24.11.2020, 14:00:06
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить книгу</title>
    </head>
    <body>
        <h1>Добавить книгу</h1>
        <form action="createBook" method="POST">
            Название книги: <input type="text" name="name" value="${name}"><br>
            Год издания: <input type="text" name="publishedYear" value="${publishedYear}"><br>
            Автор книги: <input type="text" name="author" value="${author}"><br>
            <input type="submit" name="submit" value="отправить"><br>
        </form>
    </body>
</html>
