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
 * ランキング
 */
//@NamedQueries({
//    @NamedQuery(name = "Ranking.RankingQGetRank",
//            query = "Select rownum ,temp.title_code , temp.cnt"
//            + "FROM"
//            + "(select t. title_code , count(*) as cnt from title t, disc d, receipt_details rd , store s"
//            + "WHERE t.title_code = d.title_code and d.disc_code = rd.disc_code and r.store_code = s.store_code and r.store_code = ?1"
//            + "group by t.title_code order by count(*) desc) temp"
//            + "where rownum <= 20;"),
//    })
@Entity
@Table(name = "RANKING")
public class Ranking implements Serializable {

    @Id
    @NotNull
    private int serial;       //連番
    @NotNull
    @JoinColumn(name = "store_code")
    private Store store;
    @JoinColumn(name = "title_code")
    @NotNull
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
