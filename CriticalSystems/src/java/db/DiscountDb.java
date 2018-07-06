/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Discount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class DiscountDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Discount discount) {
        em.persist(discount);
    }
    public void update (Discount discount){
        em.merge(discount);
    }
    public void delete (Discount discount){
        em.remove(discount);
    }
    public Discount find (String key){
        return em.find(Discount.class, key);
    }
    
}
