
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
        <style>
            #tDate, #sDate, #deadline, #deadlineDays{
                border: solid 0.1px;
            }
        </style>
    </head>
    <body>
        <h1>this is the <span name="user">Teacher</span> page for: ${teacher.name}</h1>
        <h2>information on your planning period for next semester is shown below</h2>
        <p>today is: <div id="tDate">${teacher.currentDate}</div></p>
    <p>semester starts at: <div id="sDate">${teacher.semester.startDate}</div></p>
<p> deadline is: <div id="deadline">${deadline}</div></p>
<p>you have this many days until deadline: <div id="deadlineDays">${deadlineDays}</div></p>
<h1 id="here"></h1>
<center>
    <h1>username: ${teacher.name} , day: ${teacher.currentDate} , semester start: ${teacher.semester.startDate}</h1>
    <h3>Welcome ${sessionScope.currentSessionUser }</h3>deadline: ${deadline}		
</center>
<h1>ignore information below... it is for selenium tests purposes...</h1>
teacherDate<input id='tDate2'>semesterStart</input><input id='sDate2'>deadline in days</input><input id='days'></input>

</body>
</html>