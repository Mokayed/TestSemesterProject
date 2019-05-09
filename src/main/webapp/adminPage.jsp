<%-- 
    Document   : adminPage
    Created on : May 1, 2019, 5:36:01 PM
    Author     : MoK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <h1 name="user">${sessionScope.userRole }</h1>
    </body>
     <center>
            
     <h3>Welcome ${sessionScope.currentSessionUser }</h3>		
         </center>
</html>
