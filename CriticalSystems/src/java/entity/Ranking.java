/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * ランキング   
 */
@Entity
public class Ranking implements Serializable{
    @Id
    @NotNull
    private Store store;
    private Title title;
    private int rankNo;

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
    public int getRankNo() {
        return rankNo;
    }

    /**
     * @param rankNo the rankNo to set
     */
    public void setRankNo(int rankNo) {
        this.rankNo = rankNo;
    }
    
}
