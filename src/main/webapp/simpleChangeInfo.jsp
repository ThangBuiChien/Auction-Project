<%-- 
    Document   : simpleChangeInfo
    Created on : Nov 30, 2023, 9:14:41 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
<p>Change info:</p>
    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="ChangeInfo"> 
        
        <label class="pad_top" >FirstName:</label>
        <input required type="text" name="firstName"
               value=${seller.firstName}><br>
        <label class="pad_top"  >Last Name:</label>
        <input required type="text" name="lastName" 
               value=${seller.lastName}><br>
        <label class="pad_top" >Company Name:</label>
        <input required type="text" name="companyName"
               value=${seller.companyName}><br>
        <label class="pad_top" >Phone number:</label>
        <input required type="text"  name="phoneNumber"
               value=${seller.phoneNumber}><br>
    

       
        <input type="submit" value="Done" class="margin_left">
        
    </form>
</section>
