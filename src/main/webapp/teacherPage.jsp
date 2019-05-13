
<%-- 
    Document   : teacherPage
    Created on : May 1, 2019, 5:35:29 PM
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
        <h1>Hello from teacher</h1>
        <button id="planBtn">see planning period</button>
        <h1 id="here"></h1>
         <center>
            
     <h3>Welcome ${sessionScope.currentSessionUser }</h3>		
         </center>
    teacherDate<input id='tDate'>semesterStart</input><input id='sDate'>deadline in days</input><input id='days'></input>
        <script>
            document.getElementById("planBtn").onclick = () => {
                document.getElementById("here").innerHTML = "you clicked...";
            }
        </script>
    </body>
</html>