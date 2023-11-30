

<section>
    
<p>Here is the information that you entered:</p>
    <label  class="right">Email: </label>
    <span>${seller.email}</span><br>
    <label class="right">First Name: </label>
    <span>${seller.firstName}</span><br>
    <label class="right">Last Name: </label>
    <span>${seller.lastName}</span><br>
    <label class="right" >Company Name: </label>
    <span>${seller.companyName}</span><br>
    <label class="right" >Phone: </label>
    <span>${seller.phoneNumber}</span><br>
    

    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="AddProduct">        
        <input type="submit" value="Add Product" class="margin_left">
     
        <input type="hidden" name="action" value="Change">        
        
        <input type="submit" value="Change Info" class="margin_left">
    </form>
    
    

        



</section>

