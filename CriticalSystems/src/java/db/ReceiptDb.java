package db;

import entity.Receipt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReceiptDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Receipt receipt) {
        em.persist(receipt);
    }
    public void update (Receipt receipt){
        em.merge(receipt);
    }
    public void delete (Receipt receipt){
        em.remove(receipt);
    }
    public Receipt find (String key){
        return em.find(Receipt.class, key);
    }
}
