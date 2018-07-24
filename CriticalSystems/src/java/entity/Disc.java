package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
* ディスク
*/
@NamedQueries({
    @NamedQuery(name = "Disc.DiscQAll" , query = "SELECT d FROM Disc d"),
    @NamedQuery(name = "Disc.DiscQ" , query = "SELECT d FROM Disc d WHERE d.disc_code LIKE :code"),
})

@Entity
@Table(name="DISC")
public class Disc implements Serializable {
    public static final String DiscQ = "DiscQ";
    public static final String DiscQAll = "DiscQAll";
//    public static final String DiscQLend = "DiscQLend";
//    public static final String DiscQRackNo = "DiscQRackNo";
//    public static final String DiscQDisposal = "DiscQDisposal";
//    
    @Id
    @NotNull
    @Column(name = "disc_code")
    private String disc_code;      //ディスクCD
    @NotNull
    @JoinColumn(name = "title_code")
    private String title_code;        //タイトル
    @Column(name = "arrival_date")
    private Date arrivalDate;   //入荷日
    @JoinColumn(name = "div_code")
    private String div_code;     //区分
    @JoinColumn(name = "rack")
    private int rack;       //連番
    @Column(name = "is_lend")
    private boolean lendFlg;    //貸出フラグ
    @Column(name = "is_disposal")
    private boolean disposalFlg;//廃棄フラグ
    @Column(name = "media")
    private String media;       //媒体区分

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
    
    /**
     * @return the title_code
     */
    public String getTitle_code() {
        return title_code;
    }

    /**
     * @param title_code the title_code to set
     */
    public void setTitle_code(String title_code) {
        this.title_code = title_code;
    }

    /**
     * @return the div_code
     */
    public String getDiv_code() {
        return div_code;
    }

    /**
     * @param div_code the div_code to set
     */
    public void setDiv_code(String div_code) {
        this.div_code = div_code;
    }

    /**
     * @return the disc_code
     */
    public String getDisc_code() {
        return disc_code;
    }

    /**
     * @param disc_code the disc_code to set
     */
    public void setDisc_code(String disc_code) {
        this.disc_code = disc_code;
    }

    /**
     * @return the rack
     */
    public int getRack() {
        return rack;
    }

    /**
     * @param rack the rack to set
     */
    public void setRack(int rack) {
        this.rack = rack;
    }
    
}
