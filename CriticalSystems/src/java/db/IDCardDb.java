package db;

import entity.IDCard;
import entity.Members1;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    public IDCard getIDCard (String member_code){
        TypedQuery<IDCard> q = em.createNamedQuery(IDCard.IDCardQgetMember,IDCard.class);
        q.setParameter(1, member_code);
        return q.getResultList().get(0);
    }
}
