/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Division;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class DivisionDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Division division) {
        em.persist(division);
    }
    public void update (Division division){
        em.merge(division);
    }
    public void delete (Division division){
        em.remove(division);
    }
    public Division find (String key){
        return em.find(Division.class, key);
    }
    
}
