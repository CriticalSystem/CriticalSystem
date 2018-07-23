package db;

import entity.Disc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DiscDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Disc disc) {
        em.persist(disc);
    }
    public void update (Disc disc){
        em.merge(disc);
    }
    public void delete (Disc disc){
        em.remove(disc);
    }
    public Disc find (String key){
        return em.find(Disc.class, key);
    }
//    public List<Disc> find(String disc_code) {
//        TypedQuery<Disc> q = em.createNamedQuery(Disc.DiscQ, Disc.class);
//        q.setParameter("code", disc_code);
//        return q.getResultList();
//    }
    public List<Disc> getAll (){
        return em.createNamedQuery(Disc.DiscQAll,Disc.class).getResultList();
    }
    
}
