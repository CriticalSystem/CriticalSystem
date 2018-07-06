/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Ranking;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class RankingDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Ranking ranking) {
        em.persist(ranking);
    }
    public void update (Ranking ranking){
        em.merge(ranking);
    }
    public void delete (Ranking ranking){
        em.remove(ranking);
    }
    public Ranking find (String key){
        return em.find(Ranking.class, key);
    }
    
}
