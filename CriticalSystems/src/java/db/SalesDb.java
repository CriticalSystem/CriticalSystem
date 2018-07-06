/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Sales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class SalesDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Sales sales) {
        em.persist(sales);
    }
    public void update (Sales sales){
        em.merge(sales);
    }
    public void delete (Sales sales){
        em.remove(sales);
    }
    public Sales find (String key){
        return em.find(Sales.class, key);
    }
    
}
