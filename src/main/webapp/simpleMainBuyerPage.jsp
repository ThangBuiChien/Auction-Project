<%-- 
    Document   : simpleMainBuyerPage
    Created on : Nov 30, 2023, 3:43:15 PM
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
        <h1>Hello World!</h1>
        
        <a href="./simpleProduct.jsp" class="margin_left">Shoping</a> <br>
    
        <a href="./cart?action=loadCart" class="margin_left">My cart</a> <br>
    
        <a href="./productServlet?action=loadProductByUser" class="margin_left">My winning product</a>
    </body>
</html>
