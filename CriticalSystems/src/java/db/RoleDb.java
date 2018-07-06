/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Role;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class RoleDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Role role) {
        em.persist(role);
    }
    public void update (Role role){
        em.merge(role);
    }
    public void delete (Role role){
        em.remove(role);
    }
    public Role find (String key){
        return em.find(Role.class, key);
    }
    
}
