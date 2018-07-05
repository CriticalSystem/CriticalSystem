package db;

import entity.IDCard;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IDCardDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (IDCard idCard) {
        em.persist(idCard);
    }
    public void update (IDCard idCard){
        em.merge(idCard);
    }
    public void delete (IDCard idCard){
        em.remove(idCard);
    }
    public IDCard find (String key){
        return em.find(IDCard.class, key);
    }
}
