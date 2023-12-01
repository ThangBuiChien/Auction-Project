<%-- 
    Document   : simpleMainPage
    Created on : Nov 29, 2023, 5:42:01 PM
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
        
<!--        <form action="userLogin" method="post">     
            <input type="hidden" name="action" value="toBuyer">            
            <input type="submit" value="Buyer" class="margin_left">
        </form>
        
        <form action="userLogin" method="post">  
            <input type="hidden" name="action" value="toSeller">
            <input type="Seller" value="Buyer" class="margin_left">

        </form>
        
        <form action="userLogin" method="post"> 
            <input type="hidden" name="action" value="toNoti">
            <input type="Notification" value="Buyer" class=>
        </form>-->
               
        
         <a href="./simpleMainBuyerPage.jsp" class="margin_left">Buyer Main Page</a> <br>
    
        <a href="./simpleAddProduct.jsp" class="margin_left">Seller</a> <br>
    
        <a href="./userLogin?action=loadNofi" class="margin_left">Notification</a>
    
        <a href="./userLogin?action=logOut" class="margin_left">Log out</a>

    </body>
</html>
