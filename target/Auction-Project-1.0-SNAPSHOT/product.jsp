<%-- 
    Document   : product
    Created on : Oct 28, 2023, 5:39:12 PM
    Author     : memo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TĐĐ Auctions</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <header>
    <h1>Welcome to TĐĐ Auctions</h1>
  </header>
  <nav class="navigation">
    <div class="nav-panel"><a href="index.html">Home</a></div>
    <div class="nav-panel">Seller</div>
    <div class="nav-panel"><a href="product.html">All Products</a></div>
    <div class="nav-panel">Register</div>
    <div class="nav-panel"><a href="contact.html">Contact</a></div>
  </nav>
  <section>
    <h2>Featured Auction Products</h2>
    <div class="auction-products">
      <div class="auction-product">
        <h3>Product 1</h3>
        <p>Start Price: $100</p>
        <p>Current Price: $150</p>
        <button class="buy-now-btn">Buy Now</button>
        <button class="notification-btn">Notify Me</button>
      </div>
    <div class="auction-product">
      <h3>Product 2</h3>
      <p>Start Price: $200</p>
      <p>Current Price: $220</p>
      <button class="buy-now-btn">Buy Now</button>
      <button class="notification-btn">Notify Me</button>
    </div>
     <div class="auction-product">
        <!-- Product 3 content -->
      </div>
      <div class="auction-product">
        <!-- Product 4 content -->
      </div>
      <div class="auction-product">
        <!-- Product 5 content -->
      </div>
    </div>
  </section>
  <footer class="footer">
    <p>&copy; 2023 TĐĐ Auctions. All Rights Reserved.</p>
  </footer>
</body>
</html>
