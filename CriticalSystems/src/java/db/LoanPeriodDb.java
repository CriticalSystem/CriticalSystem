/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.LoanPeriod;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class LoanPeriodDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (LoanPeriod loanPeriod) {
        em.persist(loanPeriod);
    }
    public void update (LoanPeriod loanPeriod){
        em.merge(loanPeriod);
    }
    public void delete (LoanPeriod loanPeriod){
        em.remove(loanPeriod);
    }
    public LoanPeriod find (String key){
        return em.find(LoanPeriod.class, key);
    }
    
}
