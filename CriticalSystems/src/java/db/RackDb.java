/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Rack;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class RackDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Rack rack) {
        em.persist(rack);
    }
    public void update (Rack rack){
        em.merge(rack);
    }
    public void delete (Rack rack){
        em.remove(rack);
    }
    public Rack find (String key){
        return em.find(Rack.class, key);
    }
    
}
