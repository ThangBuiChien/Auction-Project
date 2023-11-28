<%-- 
    Document   : simpleAddProduct
    Created on : Nov 28, 2023, 9:37:43 AM
    Author     : ThangDz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <h1>Please add product details</h1>
    <p>Please enter all the information about your product </p>
    <p><i>${message}</i></p>
    
    <form action="productServlet" method="post">
        
        <input type="hidden" name="action" value="addProduct">   
        
        
        <label class="pad_top">product Name</label>
        <input type="text" name="productName" 
               value=${product.productName} ><br>
        <label class="pad_top">Tag:</label>
        <input required type="text" name="tag" 
               value=${user.firstName}><br>
        <label class="pad_top">description:</label>
        <input required type="text" name="description" 
               value=${user.lastName}><br>
        <label class="pad_top">starting Bid Price</label>
        <input required type="text" name="startingBidPrice" 
               value=${user.addreses}><br>
        <label class="pad_top">buy Now Price:</label>
        <input required type="text" name="buyNowPrice" 
               value=${user.debitCardInfo}><br>
        
               
        <label>&nbsp;</label>
        <input type="submit" value="Add product!" class="margin_left">
    </form>
               
</html>
