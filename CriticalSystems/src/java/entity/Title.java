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
import javax.validation.constraints.NotNull;

/**
 * タイトル
 */
@Entity
@NamedQuery(name = "Title.TitleQAll" , query = "SELECT e FROM Title")
public class Title implements Serializable{
    public static final String TitleQAll = "TitleQAll";
    @Id
    @NotNull
    private String titleCD;
    @NotNull
    private String titleName;
    private String starring;
    private String rating;
    private String comment;
    @NotNull
    private Genre genre;
    @NotNull
    private String imgPath;

    /**
     * @return the TitleCD
     */
    public String gettitleCD() {
        return titleCD;
    }

    /**
     * @param TitleCD the TitleCD to set
     */
    public void setTitleCD(String titleCD) {
        this.titleCD = titleCD;
    }

    /**
     * @return the TitleName
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * @param TitleName the TitleName to set
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    /**
     * @return the syuen
     */
    public String getStarring() {
        return starring;
    }

    /**
     * @param syuen the syuen to set
     */
    public void setStarring(String starring) {
        this.starring = starring;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
}
