/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author s20163048
 */
public class Title {
    @Id
    @NotNull
    private String TitleCD;
    @NotNull
    private String TitleName;
    private String syuen;
    private String rating;
    private String comment;
    @NotNull
    private Genre genre;

    /**
     * @return the TitleCD
     */
    public String getTitleCD() {
        return TitleCD;
    }

    /**
     * @param TitleCD the TitleCD to set
     */
    public void setTitleCD(String TitleCD) {
        this.TitleCD = TitleCD;
    }

    /**
     * @return the TitleName
     */
    public String getTitleName() {
        return TitleName;
    }

    /**
     * @param TitleName the TitleName to set
     */
    public void setTitleName(String TitleName) {
        this.TitleName = TitleName;
    }

    /**
     * @return the syuen
     */
    public String getSyuen() {
        return syuen;
    }

    /**
     * @param syuen the syuen to set
     */
    public void setSyuen(String syuen) {
        this.syuen = syuen;
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
