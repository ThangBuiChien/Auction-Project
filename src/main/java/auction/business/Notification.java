
package auction.business;
    import java.text.NumberFormat;
    import java.io.Serializable;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;

public class Notification implements Serializable{
    
    @Entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    private string message;
   
    @ManyToMany(fetch=FetchType.EAGER)
    private Buyer buyer;
    
    
   public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
     public string getmessage() {
        return message;
    }

    public void setmessage(string message) {
        this.message = message;
    }
    
}
