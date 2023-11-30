/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import auction.business.Product;
import java.util.List;

/**
 *
 * @author ThangDz
 */
public class ProductDB {
     public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Product u";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        return users;
    }
    
//    public static Product selectProduct(long ID) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT p FROM Product  " +
//                "WHERE p.productID == :ID";
//        TypedQuery<Product> q = em.createQuery(qString, Product.class);
//        //q.setParameter("email", email);
//        try {
//            Product currentProduct = q.getSingleResult();
//            return currentProduct;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    public static Product selectProduct(long ID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.productID = :ID";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("ID", ID);
        try {
            Product currentProduct = q.getSingleResult();
            return currentProduct;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    
}