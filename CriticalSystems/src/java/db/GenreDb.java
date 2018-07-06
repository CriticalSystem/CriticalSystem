/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Genre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s20163048
 */
@Stateless
public class GenreDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create (Genre genre) {
        em.persist(genre);
    }
    public void update (Genre genre){
        em.merge(genre);
    }
    public void delete (Genre genre){
        em.remove(genre);
    }
    public Genre find (String key){
        return em.find(Genre.class, key);
    }
    
}
