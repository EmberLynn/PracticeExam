<%-- 
    Document   : past1
    Created on : Oct 8, 2019, 9:24:15 AM
    Author     : 738634
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practice Exam Part 1</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <form action="part1" method="post">
        <label>Enter a motivational phrase:</label>
        <input type="text" name="phrase" value="" /><br>
        <input type="submit" value="Set phrase" />
        <h2>${motivation}</h2>
        </form>
        <a href="part2">Part 2</a>
    </body>
</html>
