
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TĐĐ Auctions</title>
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="cart.css" type="text/css"/>
    </head>
    <body>
      <header>
        <h1>Welcome to TĐĐ Auctions</h1>
      </header>
      <nav class="navigation">
      <div class="nav-panel"><a href="index.html">Home</a></div>
      <div class="nav-panel">Seller</div>
      <div class="nav-panel"><a href="product.jsp">All Products</a></div>
      <div class="nav-panel">Register</div>
      <div class="nav-panel"><a href="contact.html">Contact</a></div>
    </nav>

    <section>
      <h2>Featured Auction Products</h2>
      <table>
    <form action="productServlet">
        <button> Load data </button>
    </form>
          

    <tr>
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
    
    <c:forEach var="item" items="${sessionScope.products}">
    <tr>
        <td><c:out value='${item.ID}'/></td>
        <td><c:out value='${item.productName}'/></td>
        <td><c:out value='${item.tag}'/></td>
        <td><c:out value='${item.description}'/></td>
        <td><c:out value='${item.productStatus}'/></td>
    
        <td class="right"><c:out value='${item.startingBidPrice}'/></td>
        <td class="right"><c:out value='${item.currentPrice}'/></td>
        <td class="right"><c:out value='${item.buyNowPrice}'/></td>

        <td><form action="CartServlet" method="post">
                <input type="hidden" name="productCode" value="<c:out value='${item.buyNowPrice}'/>">
                <input type="submit" value="Add To Cart">
            </form></td>
            
        <td>
            <form action="productServlet" method="post">
              <input type="hidden" name="action" value="setBidPrice">   
              
              <input type="hidden" name="productID" 
                     value="<c:out value='${item.ID}'/>">              
              <input type=text name="newBidPrice"  placeholder="Enter your discount here"
                     value="<c:out value='${item.currentPrice}'/>" id="newBidPrice" >
              <input type="submit" value="Enter new bid Price">
            </form>
        </td>
        
        <td>
            <form action="productServlet" method="post">
              <input type="hidden" name="action" value="setFinalWinner">   
              
              <input type="hidden" name="productID" 
                     value="<c:out value='${item.ID}'/>">                            
              <input type="submit" value="End of time!">
            </form>
        </td>
        
    </tr>
    </c:forEach>

    
</table>
     
    <br> 
  <footer class="footer">
    <p>&copy; 2023 TĐĐ Auctions. All Rights Reserved.</p>
  </footer>
</body>
</html>
