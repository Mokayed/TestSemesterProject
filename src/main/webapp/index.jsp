<%-- 
    Document   : index
    Created on : May 9, 2019, 1:59:57 PM
    Author     : MoK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Login Page</title>
    </head>

    <body>
        <form method="post" action="LoginServlet">

            Please enter your username 		
            <input type="text" name="un"/><br>		

            Please enter your password
            <input type="text" name="pw"/><br/>
            Please pick production or test:<br/>
            <input id="production"type="radio" name="dbPick" value="production" required>production<br>
            <input id="test"type="radio" name="dbPick" value="test">test<br>
            <input name="sub"  type="submit" value="submit">			
            <h1 id="invPara"></h1>
        </form>
        <a href="register.jsp">Register</a>
    </body>
</html>
