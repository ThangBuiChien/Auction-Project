<%-- 
    Document   : simpleCart
    Created on : Nov 30, 2023, 9:13:24 PM
    Author     : memo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>TDD e-Commerce Website</title>
    <link rel="stylesheet" href="style/main.css" type="text/css"/>
</head>
<body>
    
<h1>This is your cart</h1>

<table>
    
    
    
    <tr>
        <th>product ID </th>
        <th>product Name </th>
        <th>tag</th>
        <th>description</th>
        <th>product Status </th>
        <th class="right">starting Bid Price</th>
        <th class="right">current Price</th>
        <th class="right">buy Now Price</th>
        

        
        <th>&nbsp;</th>
     </tr>
     
        
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <p>${message}</p>
    
    <c:forEach var="item" items="${cart.listcart}">
    <tr>
        <td><c:out value='${product.productID}'/></td>
        <td><c:out value='${product.productName}'/></td>
        <td><c:out value='${product.tag}'/></td>
        <td><c:out value='${product.description}'/></td>
        <td><c:out value='${product.productStatus}'/></td>
    
        <td class="right"><c:out value='${product.startingBidPrice}'/></td>
        <td class="right"><c:out value='${product.currentPrice}'/></td>
        <td class="right"><c:out value='${product.buyNowPrice}'/></td>
        
     
            
        <td>
            <form action="productServlet" method="post">
              <input type="hidden" name="action" value="setBidPrice">   
              
              <input type="hidden" name="productID" 
                     value="<c:out value='${product.productID}'/>">              
              <input type=text name="newBidPrice"  placeholder="Enter your bid here"
                     value="<c:out value='${product.currentPrice}'/>" id="newBidPrice" >
              <input type="submit" value="Enter new bid Price">
            </form>
        </td>
        
        
        
    </tr>
    </c:forEach>

    
</table>
</body>    
</html>
