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
//    public static Cart sellectProduct(int productID){
//        String qString = "SELECT u FROM Cart u " +
//                "WHERE u.id = :email";
//        TypedQuery<Buyer> q = em.createQuery(qString, Buyer.class);
//        q.setParameter("email", email);
//        try {
//            Buyer user = q.getSingleResult();
//            return user;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
}
