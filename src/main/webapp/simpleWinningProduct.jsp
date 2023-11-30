<%-- 
    Document   : simpleWinningProduct
    Created on : Nov 30, 2023, 3:37:32 PM
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
        <h1>Hello World!</h1>
        
        <table>
            <tr>
                <th>product ID </th>
                <th>product Name </th>
                <th>tag</th>
                <th>description</th>
                <th class="right">starting Bid Price</th>
                <th class="right">Your winning Bid Price</th>
            </tr>
            
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="item" items="${requestScope.products}">
                <tr>
                    <td><c:out value='${item.ID}'/></td>
                    <td><c:out value='${item.productName}'/></td>
                    <td><c:out value='${item.tag}'/></td>
                    <td><c:out value='${item.description}'/></td>
                    <td><c:out value='${item.startingBidPrice}'/></td>
                    <td><c:out value='${item.currentPrice}'/></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
