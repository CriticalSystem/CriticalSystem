package db;

import entity.Member;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MemberDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Member member) {
        em.persist(member);
    }
    public void update (Member member){
        em.merge(member);
    }
    public void delete (Member member){
        em.remove(member);
    }
    public Member find (String key){
        return em.find(Member.class, key);
    }
    public List<Member> getAll (){
        return em.createNamedQuery(Member.MemberQAll,Member.class).getResultList();
    }
            
}
