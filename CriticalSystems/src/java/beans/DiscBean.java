package db;

import entity.Event;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class EventDb {

    @PersistenceContext
    private EntityManager em;
    
    public void create(Event event) {
        em.persist(event);
    }
    
    public void update(Event event) {
        em.merge(event);
    }
    
    public void delete(Event event) {
        em.remove(em.merge(event));
    }
    
    public Event find(Integer key) {
        return em.find(Event.class, key);
    }
    
    public List<Event> find(String name) {
        TypedQuery<Event> q = em.createNamedQuery(Event.EventQName, Event.class);
        q.setParameter(1, name);
        return q.getResultList();
    }
    
    public List<Event> getAll() {
        return em.createNamedQuery(Event.EventQAll, Event.class).getResultList();
    }
}
