/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Job;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class JobDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Job job) {
        em.persist(job);
    }
    public void update (Job job){
        em.merge(job);
    }
    public void delete (Job job){
        em.remove(job);
    }
    public Job find (String key){
        return em.find(Job.class, key);
    }
    
}
