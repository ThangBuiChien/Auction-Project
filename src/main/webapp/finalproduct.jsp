<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">TDD Auction </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item m-auto">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="category.html">Seller</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="finalproduct.jsp">Product1</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="contact.html">Cart <span class="sr-only">(</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Contact</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                
                <a class="btn btn-success btn-sm ml-3" href="cart.html">
                    <i class="fa fa-shopping-cart"></i> Cart
                   
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">TDD Auction Product</h1>
     </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
        <th>product ID </th>
        <th>product Name </th>
        <th>tag</th>
        <th>description</th>
        <th>product Status </th>
        <th class="right">starting Bid Price</th>
        <th class="right">current Price</th>
        <th class="right">buy Now Price</th>
        <th>End time </th>
        <th>&nbsp;</th>
     </tr>
     
        
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <p>${message}</p>
    
    
    <div class="input-group input-group-sm">
    <form action="productServlet" method="post" class="input-group">
        <input type="hidden" name="action" value="loadProductByName">
        <input type="text" class="form-control" id="name" name="productNameSearch" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." required>
        <div class="input-group-append">
            <button type="submit" class="btn btn-secondary btn-number">
                <i class="fa fa-search"></i>
            </button>
        </div>
    </form>
    </div>
    
    
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

                <td><c:out value='${item.getEndDatetime()}'/></td>

                <td><form action="cart" method="post">
                        <input type="hidden" name="action" value="addcart"> 
                        <input type="hidden" name="productCode" value="<c:out value='${item.ID}'/>">
                        <input type="submit" value="Add To Cart">
                    </form></td>

                <td>
                    <form action="productServlet" method="post">
                      <input type="hidden" name="action" value="setBidPrice">   

                      <input type="hidden" name="productID" 
                             value="<c:out value='${item.ID}'/>">              
                      <input type=text name="newBidPrice"  placeholder=""
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
    
<!--    <form action="productServlet">
        <button>load product </button>
    </form>-->
            </div>
        </div>
        
    </div>
</div>



<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
