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
    </head>
    <body>
        <h1>Your inbox</h1>
        
        <form action="userLogin" method="loadNofi">
        
        <input type="hidden" name="action" value="loadNofi"> 
        
        <button>Send</button>
        
        
        
        </form>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <c:forEach var="nofi" items="${request.nofi}">
            <table>
                <tr>
                    <td> ${nofi.getMessage()}
                </tr>
            </table>
        </c:forEach>

    </body>
</html>
