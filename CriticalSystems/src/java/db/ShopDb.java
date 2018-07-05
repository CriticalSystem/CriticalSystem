package db;

import entity.Store;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShopDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Store shop) {
        em.persist(shop);
    }
    public void update (Store shop){
        em.merge(shop);
    }
    public void delete (Store shop){
        em.remove(shop);
    }
    public Store find (String key){
        return em.find(Store.class, key);
    }
    public List<Store> getAll (){
        return em.createNamedQuery(Store.ShopQAll,Store.class).getResultList();
    }
            
}
