package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/*
* ディスク
*/

@Entity
@NamedQueries({
    @NamedQuery(name = "Disc.DiscQAll" , query = "SELECT e FROM disc"),
    @NamedQuery(name = "Disc.DiscQ" , query = "SELECT e FROM disc WHERE title_code = :1"),
    @NamedQuery(name = "Disc.DiscQ" , query = "UPDATE disc SET is_lend = 1 WHERE disc_code = :1")
})
public class Disc implements Serializable {
    public static final String DiscQAll = "DiscQAll";
    public static final String DiscQ = "DiscQ";
    @Id
    @NotNull
    private String discCD;      //ディスクCD
    @NotNull
    private Title title;        //タイトル
    private int rackNo;         //棚番号
    @NotNull
    private Date arrivalDate;   //入荷日
    private String sorting;     //区分
    private Store store;        //店舗
    @NotNull
    private boolean lendFlg;    //貸出フラグ
    @NotNull
    private boolean disposalFlg;//廃棄フラグ
    @NotNull
    private String media;       //媒体区分

    /**
     * @return the DiscCD
     */
    public String getDiscCD() {
        return discCD;
    }

    /**
     * @param DiscCD the DiscCD to set
     */
    public void setDiscCD(String DiscCD) {
        this.discCD = DiscCD;
    }

    /**
     * @return the Title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(Title Title) {
        this.title = Title;
    }

    /**
     * @return the tanaNo
     */
    public int getRackNo() {
        return rackNo;
    }

    /**
     * @param RackaNo the rackNo to set
     */
    public void setRackNo(int rackNo) {
        this.rackNo = rackNo;
    }

    /**
     * @return the Date
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the sorting
     */
    public String getMedia() {
        return sorting;
    }

    /**
     * @param kubun the sorting to set
     */
    public void setKubun(String kubun) {
        this.sorting = kubun;
    }

    /**
     * @return the Store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param Store the Store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the flg
     */
    public boolean isLendFlg() {
        return lendFlg;
    }

    /**
     * @param flg the flg to set
     */
    public void setLendFlg(boolean lendFlg) {
        this.lendFlg = lendFlg;
    }

    /**
     * @return the disposalFlg
     */
    public boolean isDisposalFlg() {
        return disposalFlg;
    }

    /**
     * @param disposalFlg the disposalFlg to set
     */
    public void setDisposalFlg(boolean disposalFlg) {
        this.disposalFlg = disposalFlg;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    
}
