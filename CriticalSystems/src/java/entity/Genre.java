/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * ジャンル
 */

@Entity
@NamedQuery(name = "Genre.GenreQAll" , query = "SELECT e FROM Genre")
public class Genre implements Serializable{
    @Id
    private String genreCD;
    private String genreName;

    /**
     * @return the genreCD
     */
    public String getGenreCD() {
        return genreCD;
    }

    /**
     * @param genreCD the genreCD to set
     */
    public void setGenreCD(String genreCD) {
        this.genreCD = genreCD;
    }

    /**
     * @return the genreName
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * @param genreName the genreName to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
    
}
