/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Members1;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163045
 */
@Stateless
public class MembersDb1 {
    @PersistenceContext
    private EntityManager em;
    
    public List<Members1> getAll (){
        return em.createNamedQuery(Members1.MembersQ,Members1.class).getResultList();
    }
    
}
