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
            <input type="text" name="pw"/>

            <input name="sub"  type="submit" value="submit">			
            <h1 id="invPara"></h1>
        </form>
    </body>
</html>
