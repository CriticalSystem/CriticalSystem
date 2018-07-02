package db;

import entity.Shop;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ShopDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Shop shop) {
        em.persist(shop);
    }
    public void update (Shop shop){
        em.merge(shop);
    }
    public void delete (Shop shop){
        em.remove(shop);
    }
    public Shop find (String key){
        return em.find(Shop.class, key);
    }
    public List<Shop> getAll (){
        return em.createNamedQuery(Shop.ShopQAll,Shop.class).getResultList();
    }
            
}
