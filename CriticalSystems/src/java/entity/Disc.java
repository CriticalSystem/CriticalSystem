package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
* ディスク
*/
@NamedQueries({
    @NamedQuery(name = "Disc.DiscQAll" , query = "SELECT e FROM disc"),
    
})

@Entity
@Table(name="DISC")
public class Disc implements Serializable {
    public static final String DiscQAll = "DiscQAll";
    public static final String DiscQLend = "DiscQLend";
    public static final String DiscQRackNo = "DiscQRackNo";
    public static final String DiscQDisposal = "DiscQDisposal";
    
    @Id
    @NotNull
    @Column(name = "disc_code")
    private String discCD;      //ディスクCD
    @NotNull
    @Column(name = "title_code")
    private Title title;        //タイトル
    @Column(name = "rack_number")
    private int rackNo;         //棚番号
    @NotNull
    @Column(name = "arrival_date")
    private Date arrivalDate;   //入荷日
    @Column(name = "div_code")
    private String division;     //区分
    @Column(name = "store_code")
    private Store store;        //店舗
    @NotNull
    @Column(name = "is_lend")
    private boolean lendFlg;    //貸出フラグ
    @NotNull
    @Column(name = "is_disposal")
    private boolean disposalFlg;//廃棄フラグ
    @NotNull
    @Column(name = "media")
    private String media;       //媒体区分

    /**
     * @return the discCD
     */
    public String getDiscCD() {
        return discCD;
    }

    /**
     * @param discCD the discCD to set
     */
    public void setDiscCD(String discCD) {
        this.discCD = discCD;
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
     * @return the rackNo
     */
    public int getRackNo() {
        return rackNo;
    }

    /**
     * @param rackNo the rackNo to set
     */
    public void setRackNo(int rackNo) {
        this.rackNo = rackNo;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

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
     * @return the lendFlg
     */
    public boolean isLendFlg() {
        return lendFlg;
    }

    /**
     * @param lendFlg the lendFlg to set
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
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }
    
    
}
