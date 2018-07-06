/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.RegisterInfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class RegisterInfoDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (RegisterInfo registerInfo) {
        em.persist(registerInfo);
    }
    public void update (RegisterInfo registerInfo){
        em.merge(registerInfo);
    }
    public void delete (RegisterInfo registerInfo){
        em.remove(registerInfo);
    }
    public RegisterInfo find (String key){
        return em.find(RegisterInfo.class, key);
    }
    
}
