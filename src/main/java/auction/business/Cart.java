/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrator
 */
@Entity
public class Cart implements Serializable {
    
//    @ManyToOne(fetch=EAGER, cascade=CascadeType.PERSIST)  
//    private List<Product> listcart;
    
    @OneToMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Product> listcart;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setListcart(List<Product> listcart) {
        this.listcart = listcart;
    }

    public List<Product> getListcart() {
        return listcart;
    }
    
    
}
