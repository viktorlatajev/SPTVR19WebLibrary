<%-- 
    Document   : listBooks
    Created on : 01.12.2020, 13:03:47
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Список книг</h1>

        <c:forEach var="book" items="${listBooks}" varStatus="status">
            <li>${status.index+1}. ${book.name}. ${book.author}. ${book.publishedYear}</li>
        </c:forEach>


    </body>
</html>