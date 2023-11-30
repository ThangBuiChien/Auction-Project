<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="cart.css" type="text/css"/>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
</head>
<body>
<header>
    <h1>Welcome to the TDD Website</h1>
  </header>
    <nav class="navigation">
    <div class="nav-panel"><a href="index.html">Home</a></div>
    <div class="nav-panel"><a href="seller.html">Seller</a></div>
    <div class="nav-panel"><a href="product.jsp">All Products</a></div>
    <div class="nav-panel"><a href="login.html">Register</a></div>
    <div class="nav-panel"><a href="contact.html">Contact</a></div>
    <div class="nav-panel"><a href="cart.jsp">Cart</a></div>
    </nav>
<section class="cart">    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<h1>Your Cart</h1>

<c:choose>
      <c:when test="${emptyCart != null}">
          <p>Your cart is empty.</p>
      </c:when>
      <c:otherwise>
            <table>
              <tr>
                <th>Product id</th>
                <th>My bid price</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Start Price</th>
                <th>Current Bid Price</th>
                <th>Buy Now Price</th>
                <th>Start Date</th>
                <th>Amount</th>
              </tr>

            
            <c:forEach var="listcart" items="${cart.listcart}">
              <tr>
                <td>
                  <form action="" method="post">
                    <input type="hidden" name="productCode" 
                           value="<c:out value='${item.Product.code}'/>">
                    <input type="text" name="bidPrice" 
                           value="<c:out value='${item.id.BidPrice}'/>" id="bidPrice">
                    <input type="submit" value="Update Bid Price">
                  </form>
                </td>
                <td><c:out value='${item.product.productName}'/></td>
                <td><c:out value='${item.product.description}'/></td>
                <td>${item.product.currentBidPrice}</td>
                <td>${item.product.startDate}</td>
                <td>${item.totalCurrencyFormat}</td>
                <td>
                  <form action="cart" method="post">
                    <input type="hidden" name="productID" 
                           value="<c:out value='${item.Product.productID}'/>">
                    <input type="submit" value="AddCart">
                  </form>

                </td>
                <td>
                   <form action="updatebid" method="post">
                        <input type="hidden" name="action" value="Update bid">
                        <input type="submit" value="Update bid">
                    </form> 
                </td>
                <td>
                   <form action="buynow" method="post">
                        <input type="hidden" name="action" value="buynow">
                        <input type="submit" value="BuyNow">
                    </form> 
                </td>
                <td>
                    <form action="deletecart" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                </td>
              </tr>
            </c:forEach>
            </table>
        </c:otherwise>
</c:choose>

  




<br> 

</body>
</html>