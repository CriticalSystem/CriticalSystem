/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.TempMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class TempMemberDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (TempMember tempMember) {
        em.persist(tempMember);
    }
    public void update (TempMember tempMember){
        em.merge(tempMember);
    }
    public void delete (TempMember tempMember){
        em.remove(tempMember);
    }
    public TempMember find (String key){
        return em.find(TempMember.class, key);
    }
    
}
