/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Event;
import entity.Title;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    public Title find (String title_code){
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
