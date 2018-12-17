package db;

import entity.Disc;
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
    public void delete (String key){
        em.remove(key);
    }
    public Receipt find (String key){
        return em.find(Receipt.class, key);
    }
    
    public List<Receipt> getAll (){
        return em.createNamedQuery(Receipt.ReceiptQAll,Receipt.class).getResultList();
    }
    
    public void del(){
        em.createNamedQuery(Receipt.ReceiptDel, Receipt.class);
    }
}
