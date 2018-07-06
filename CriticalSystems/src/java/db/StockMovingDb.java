/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.StockMoving;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class StockMovingDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (StockMoving stockMoving) {
        em.persist(stockMoving);
    }
    public void update (StockMoving stockMoving){
        em.merge(stockMoving);
    }
    public void delete (StockMoving stockMoving){
        em.remove(stockMoving);
    }
    public StockMoving find (String key){
        return em.find(StockMoving.class, key);
    }
    
}
