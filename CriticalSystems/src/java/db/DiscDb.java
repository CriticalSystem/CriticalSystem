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
    public Disc find (String disc_code){
        return em.find(Disc.class, disc_code);
    }
    public List<Disc> getAll (){
        return em.createNamedQuery(Disc.DiscQAll,Disc.class).getResultList();
    }
    
}
