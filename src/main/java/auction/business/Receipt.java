
package auction.business;
    import java.io.Serializable;
    import java.util.Date;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;


public class Receipt implements Serializable{
    
    @Entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date purchaseDate;
   
    @OneToOne(fetch = FetchType.EAGER)
    private Buyer buyer;
    @OneToOne(fetch = FetchType.EAGER)
    private Product productInfo;
    
    public Buyer getbuyer() {
        return buyer;
    }

    public void setbuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    public Date getpurchaseDate() {
        return purchaseDate;
    }

    public void setpurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public Product getproductinfo() {
        return productinfo;
    }

    public void setProduct(Product productinfo) {
        this.productinfo = productinfo;
    }
    
}
