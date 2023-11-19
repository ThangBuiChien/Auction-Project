
package auction.business;

import java.text.NumberFormat;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable{
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String message;
   
    @ManyToMany(fetch=FetchType.EAGER)
    private Buyer buyer;
    
    
   public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
     public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
    
}
