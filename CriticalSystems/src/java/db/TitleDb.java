/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Title;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class TitleDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Title title) {
        em.persist(title);
    }
    public void update (Title title){
        em.merge(title);
    }
    public void delete (Title title){
        em.remove(title);
    }
    public Title find (String key){
        return em.find(Title.class, key);
    }
    
}
