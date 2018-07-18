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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * タイトル
 */
@NamedQueries({
        @NamedQuery(name = "Title.TitleQAll" , query = "SELECT t FROM Title t"),
//        @NamedQuery(name = "Title.TitleQSearch" , 
//                    query = "SELECT t.title_code, t.title_name , COUNT(d.disc_code) FROM Title t, genre g, disc d" +
//                            "WHERE t.genre_code = g.genre_code AND t.title_code = d.title_code AND" +
//                            "t.title_name LIKE %| ?1 |% AND t.genre_code LIKE ?2 AND d.media LIKE ?3 AND d.store_code = ?4" +
//                            "GROUP BY t.title_code,t.title_name;"),
//        @NamedQuery(name = "" , query = ""),
})
@Entity 
@Table(name="TITLE")
public class Title implements Serializable{
    public static final String TitleQAll = "TitleQAll";
    public static final String TitleQSearch = "TitleQSearch";
    
    @Id
    @NotNull
    @Column(name = "Title_code")
    private String titleCD;
    @NotNull
    @Column(name = "Title_name")
    private String titleName;
    @Column(name = "starring")
    private String starring;
    @NotNull
    @Column(name = "rating")
    private String rating;
    @Column(name = "comment")
    private String comment;
    @NotNull
    @JoinColumn(name = "genre_code")
    private Genre genre;
    @NotNull
    @Column(name = "imgPath")
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

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    }
