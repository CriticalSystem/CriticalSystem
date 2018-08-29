/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Title;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
    
    @Inject
    transient Logger log;
    
    public void create (Title title) {
        em.persist(title);
    }
    public void update (Title title){
        em.merge(title);
    }
    public void delete (Title title){
        em.remove(title);
    }
    public Title find (String title_code){
        log.info("dbtest");
        return em.find(Title.class, title_code);
    }
    
//    /*
//    * DVD検索
//    */
//    public List<Title> getSearch (String name ,String genre, String media, String store ){
//        TypedQuery<Title> q = em.createNamedQuery(Title.TitleQSearch, Title.class);
//        q.setParameter(1,name);
//        q.setParameter(2,genre);
//        q.setParameter(3,media);
//        q.setParameter(4,store);
//        return q.getResultList();
//    }
    
}
