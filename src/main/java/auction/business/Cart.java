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
    @OneToOne
    private Buyer currentbuyer; 
    @OneToMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Product> listcart;
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Buyer getBuyer() {
        return currentbuyer;
    }

    public void setBuyer(Buyer currentbuyer) {
        this.currentbuyer = currentbuyer;
    }
    public void setListcart(List<Product> listcart) {
        this.listcart = listcart;
    }

    public List<Product> getListcart() {
        return listcart;
    }
    public void addItem(Product product) {
        if (listcart == null) {
            listcart = new ArrayList<>();
        }
        boolean productAlreadyInCart = false;
        for (Product cartProduct : listcart) {
            if (cartProduct.getID() == product.getID()) {
                // Product is already in the cart
                // You can update quantity or take other action if needed
                productAlreadyInCart = true;
                break;
            }
        }

        // If the product is not already in the cart, add it
        if (!productAlreadyInCart) {
            listcart.add(product);
            setBuyer(currentbuyer);
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
