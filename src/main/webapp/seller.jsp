<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TDD Auctions</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <header>
    <h1>Welcome to TDD Auctions</h1>
  </header>
  <nav class="navigation">
    <div class="nav-panel"><a href="index.html">Home</a></div>
    <div class="nav-panel">Seller</div>
    <div class="nav-panel"><a href="product.html">All Products</a></div>
    <div class="nav-panel">Register</div>
    <div class="nav-panel"><a href="contact.html">Contact</a></div>
  </nav>
  <section>
    <h2>About Information</h2>
<form>
    <div class="form-detail">
      <div class="form-info col-md-6 col-xs-12">
        <div class="group">      
          <c:out class="control-custom" type="text"/>
          <span class="bar"></span>
          <label>Full name</label>
        </div>
        <div class="group">      
          <input class="control-custom" type="text"/>
          <span class="bar"></span>
          <label>Email</label>
        </div>
        <div class="group">      
          <input class="control-custom" type="text"/>
          <span class="bar"></span>
          <label>Phone</label>
        </div>
      </div>
      <div class="form-message col-md-6 col-xs-12">
        <div class="group">      
          <textarea class="control-custom" rows="10"></textarea>
          <span class="bar"></span>
          <label>Message</label>
        </div>
      </div>
    </div>
    <div class="form-button text-center">
      <button class="btn btn-info" type="submit">Submit</button>
    </div>
</form> 

  </section>
  <footer class="footer">
    <p>&copy; 2023 T?? Auctions. All Rights Reserved.</p>
  </footer>
</body>
</html>
