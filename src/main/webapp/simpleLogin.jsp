<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    
</head>
<body>-->


    <h1>LOGIN PAGE</h1>
    <p>please enter your email and password to login</p>
    <p><i>${message}</i></p>
    
    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="login">        
        <label class="pad_top">Email:</label>
        <input type="email" name="email" 
               ><br>
        <label class="pad_top">Password:</label>
        <input required type="text" name="password" 
               ><br>
               
        <label>&nbsp;</label>
        <input type="submit" value="Login" class="margin_left">
    </form>
               
    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="createNewAccount">        
        
        <input type="submit" value="Create new account" class="margin_left">
    </form>
        
     
        

<!--</body>


</html>-->