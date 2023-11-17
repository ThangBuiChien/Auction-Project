 package auction.business;
   
    import java.io.Serializable;
    import javax.persistence.Entity;

 public class Cart  implements Serializable {
    @Entity
    
    @OnetoMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Product> cartItems;
   
 
    public List<Product> getcartItems() {
        return cartItems;
    }
    public void setcartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }
    
}