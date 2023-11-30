<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    
</head>
<body>-->


    <h1>More information about you</h1>
    <p>Please enter all the information </p>
    <p><i>${message}</i></p>
    
    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="addInformation">

        
        <label class="pad_top">Email:</label>
        <input type="email" name="email" 
               value=${user.email} disabled><br>
        <label class="pad_top">First Name:</label>
        <input required type="text" name="firstName" 
               value=${user.firstName}><br>
        <label class="pad_top">Last Name:</label>
        <input required type="text" name="lastName" 
               value=${user.lastName}><br>
        <label class="pad_top">Address:</label>
        <input required type="text" name="address" 
               value=${user.address}><br>
        <label class="pad_top">Debit card info:</label>
        <input required type="text" name="debitCardInfo" 
               value=${user.debitCardInfo}><br>
        
               
        <label>&nbsp;</label>
        <input type="submit" value="Join Now" class="margin_left">
    </form>
        
     
        

<!--</body>


</html>-->