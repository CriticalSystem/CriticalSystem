package db;

import entity.ReceiptDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReceiptDetailsDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (ReceiptDetails receiptDetail) {
        em.persist(receiptDetail);
    }
    public void update (ReceiptDetails receiptDetail){
        em.merge(receiptDetail);
    }
    public void delete (ReceiptDetails receiptDetail){
        em.remove(receiptDetail);
    }
    public ReceiptDetails find (String key){
        return em.find(ReceiptDetails.class, key);
    }
}
