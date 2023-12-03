/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import auction.business.*;

public class CartDB {
    public static void insert(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//public static Cart selectCart(Long buyerID) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//
//        String qString = "SELECT u FROM Cart u " +
//                "WHERE u.buyerid = :buyerID";
//        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
//        q.setParameter("buyerID", buyerID);
//
//        try {
//            Cart cart = q.getSingleResult();
//            return cart;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
//
//    public static Cart selectCart() {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//
//        String qString = "SELECT u FROM Cart u";
//        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
//
//        try {
//            Cart cart = q.getSingleResult();
//            return cart;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    
}
