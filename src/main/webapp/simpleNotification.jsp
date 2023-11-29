<%-- 
    Document   : simpleNotification.jsp
    Created on : Nov 29, 2023, 5:57:31 PM
    Author     : ThangDz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style/main.css" type="text/css"/>

    </head>
    <body>
        <h1>Your inbox</h1>
        
        <form action="userLogin" method="loadNofi">
        
        <input type="hidden" name="action" value="loadNofi"> 
        
        <button>Send</button>
        
        
        
        </form>
        
<!--        <body onload="document.notificationForm.submit();">
            <form name="notificationForm" action="userLogin" method="get">
                <input type="hidden" name="action" value="loadNofi">
                <button>Send</button>
            </form>
        </body>-->
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          
        
        
        <c:forEach var="item" items="${requestScope.nofi}">
            <table>
                <tr>
                    <td> ${item.message} </td>
                </tr>
            </table>
        </c:forEach>

    </body>
</html>
