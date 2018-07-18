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
    @NamedQuery(name = "Disc.DiscQAll" , query = "SELECT d FROM Disc d")
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
    @JoinColumn(name = "title_code")
    private Title title;        //タイトル
    
    @NotNull
    @Column(name = "arrival_date")
    private Date arrivalDate;   //入荷日
    @JoinColumn(name = "div_code")
    private Division division;     //区分
    @JoinColumn(name = "serial_number")
    private int serial;       //連番
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
     * @return the division
     */
    public Division getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     * @return the serial
     */
    public int getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(int serial) {
        this.serial = serial;
    }
    
    
}
