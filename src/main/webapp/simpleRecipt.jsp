<%-- 
    Document   : simpleRecipt
    Created on : Dec 4, 2023, 10:05:04 PM
    Author     : ThangDz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/main.css" type="text/css"/>

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thanks you for using our services</h1>
    <p>This is your invoice</p>   
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <p>Your info: </p> <br>
    <p>Your Name: ${receipt.getBuyer().firstName} ${receipt.getBuyer().lastName} </p>
    <p>Your address:${receipt.getBuyer().address} </p>
    <p>Your email: ${receipt.getBuyer().email} </p><!-- comment -->
    
    <p>Detail of winning product: </p>
    <table>
        <tr>
            <th>Product Name </th>
            <th>Description</th>
            <th>Seller Name</th>
            <th>Starting Bid Price</th>
            <th>Your winning price</th>
        </tr>
        <tr>
            <td>${receipt.getProduct().productName}</td>
            <td>${receipt.getProduct().description}</td>
            <td>${receipt.getProduct().getSeller().firstName} ${receipt.getProduct().getSeller().firstName} </td>
            <td>${receipt.getProduct().startingBidPrice}</td>
            <td>${receipt.getProduct().currentPrice}</td>

        </tr>
    </table>
        

        
    
    
    
    
    
    </body>
</html>
