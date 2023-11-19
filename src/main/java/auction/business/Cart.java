package auction.business;
   
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable {
    
    private Long cartId;
    @OnetoMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Product> cartItems;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCartId() {
        return cartId;
    }
          
    public List<Product> getcartItems() {
        return cartItems;
    }
    public void setcartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }
    
}