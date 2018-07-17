package db;

import entity.Members;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MembersDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Members members) {
        em.persist(members);
    }
    public void update (Members members){
        em.merge(members);
    }
    public void delete (Members members){
        em.remove(members);
    }
    
    public Members find(String members_code){
        return em.find(Members.class, members_code);
    }
    
//   public List<Member> find(String members_code) {
//        TypedQuery<Member> q = em.createNamedQuery(Member.MemberQCode, Member.class);
//        q.setParameter(1, members_code);
//        return q.getResultList();
//    }
   
    public List<Members> getAll (){
        return em.createNamedQuery(Members.MembersQAll,Members.class).getResultList();
    }
    
            
}
