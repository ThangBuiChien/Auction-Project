
package auction.business;

import java.text.NumberFormat;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Notification implements Serializable{

    @ManyToMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Seller> listseller;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNoti;
    private String message;

    public Long getIdNoti() {
        return idNoti;
    }

    public void setIdNoti(Long idNoti) {
        this.idNoti = idNoti;
    }
    public void setListseller(List<Seller> listseller) {
        this.listseller = listseller;
    }

    public List<Seller> getListseller() {
        return listseller;
    }
      public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
