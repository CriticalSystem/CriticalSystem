package db;

import entity.Store;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StoreDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Store store) {
        em.persist(store);
    }
    public void update (Store store){
        em.merge(store);
    }
    public void delete (Store store){
        em.remove(store);
    }
    public Store find (String key){
        return em.find(Store.class, key);
    }
    public List<Store> getAll (){
        return em.createNamedQuery(Store.StoreQAll,Store.class).getResultList();
    }
            
}
