package db;

import entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Employee emp) {
        em.persist(emp);
    }
    public void update (Employee emp){
        em.merge(emp);
    }
    public void delete (Employee emp){
        em.remove(emp);
    }
    public void find (){
        
    }
    public List<Employee> getAll (){
        return em.createNamedQuery(Employee.EmployeeQAll,Employee.class).getResultList();
    }
            
}
