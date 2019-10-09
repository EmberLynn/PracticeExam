<%-- 
    Document   : part2
    Created on : Oct 8, 2019, 10:49:10 AM
    Author     : 738634
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CPRG-352 Practice Exam 1</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <h2>${motivation}</h2>
        <form action="part2" method="post">
        <label>Name:</label>
        <input type="text" name="name" value="" /><br>
        <label>Age:</label>
        <input type="text" name="age" value="" /><br>
        <input type="submit" value="Add" />
        <span>${error}<span>
        <p>Average age:${average}</p>
    </body>
</html>
