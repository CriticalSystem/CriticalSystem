/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Register;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class RegisterDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Register regsiter) {
        em.persist(regsiter);
    }
    public void update (Register regsiter){
        em.merge(regsiter);
    }
    public void delete (Register regsiter){
        em.remove(regsiter);
    }
    public Register find (String key){
        return em.find(Register.class, key);
    }
    
}
