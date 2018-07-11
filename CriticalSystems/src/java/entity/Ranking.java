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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * ランキング   
 */
@Entity
@Table(name="RANKING")
public class Ranking implements Serializable{
    @Id
    @NotNull
    @Column(name = "store_code")
    private Store store;
    @Column(name = "title_code")
    private Title title;
    @Column(name = "ranking")
    private int ranking;

    /**
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * @return the rankNo
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * @param ranking the rankNo to set
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
}
