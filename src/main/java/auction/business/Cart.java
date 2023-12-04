/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Administrator
 */
@Entity
public class Cart implements Serializable {
    
//    @ManyToOne(fetch=EAGER, cascade=CascadeType.PERSIST)  
//    private List<Product> listcart;
    
   
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
     
    @OneToMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Product> listcart;
    
    @OneToOne
    private Buyer buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setListcart(List<Product> listcart) {
        this.listcart = listcart;
    }
    
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer currentbuyer) {
        this.buyer = currentbuyer;
    }

    public List<Product> getListcart() {
        return listcart;
    }
    //if not exist then add, if exist then update
    public void addItem(Product product) {
        if (listcart == null) {
            listcart = new ArrayList<>();
        }
        boolean productExist =false;
        for (Product item :listcart){
            if(item.getID()==product.getID()){
                productExist = true;
                //update the new price for existed product and winer
                item.setCurrentPrice(product.getCurrentPrice());
                item.setWinner(product.getWinner());
                break;
            }
        }
        if (!productExist){
            listcart.add(product);
        }
        
    }  
    
    public void removeItem(int productID) {
        // Find the product in the cart based on the product ID
        Iterator<Product> iterator = listcart.iterator();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (item.getID() == productID) {
                iterator.remove();
                break; // Assuming each product ID is unique, exit loop after removal
            }
        }
   }
    
}
