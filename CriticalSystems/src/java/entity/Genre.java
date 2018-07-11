/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * ジャンル
 */
@NamedQueries({
    @NamedQuery(name = "Genre.GenreQAll" , query = "SELECT g FROM Genre g")
})
@Entity
@Table(name="GENRE")
public class Genre implements Serializable{
    @Id
    @NotNull
    @Column(name = "genre_code")
    private String genreCD;     //ジャンルCD
    @NotNull
    @Column(name = "genre_name")
    private String genreName;   //ジャンル名

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
