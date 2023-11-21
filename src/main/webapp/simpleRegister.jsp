<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    
</head>
<body>-->


    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and
       email address below..</p>
    <p><i>${message}</i></p>
    
    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="register">        
        <label class="pad_top">Email:</label>
        <input type="email" name="email" 
               value=${user.email}><br>
        <label class="pad_top">Password:</label>
        <input required type="text" name="password" 
               value=${user.Password}><br>
               
        <label>&nbsp;</label>
        <input type="submit" value="Join Now" class="margin_left">
    </form>
        
     
        

<!--</body>


</html>-->