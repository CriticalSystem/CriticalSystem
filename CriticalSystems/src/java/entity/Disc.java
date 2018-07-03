package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
* ディスク
*/


public class Disc implements Serializable {

    @Id
    @NotNull
    private String DiscCD;
    @NotNull
    private Title Title;
    private int tanaNo;
    private Date Date;
    private String kubun;
    private Shop Shop;
    private boolean kasidasiflg;
    private boolean haikiflg;
    private String baitai;

    /**
     * @return the DiscCD
     */
    public String getDiscCD() {
        return DiscCD;
    }

    /**
     * @param DiscCD the DiscCD to set
     */
    public void setDiscCD(String DiscCD) {
        this.DiscCD = DiscCD;
    }

    /**
     * @return the Title
     */
    public Title getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(Title Title) {
        this.Title = Title;
    }

    /**
     * @return the tanaNo
     */
    public int getTanaNo() {
        return tanaNo;
    }

    /**
     * @param tanaNo the tanaNo to set
     */
    public void setTanaNo(int tanaNo) {
        this.tanaNo = tanaNo;
    }

    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the kubun
     */
    public String getKubun() {
        return kubun;
    }

    /**
     * @param kubun the kubun to set
     */
    public void setKubun(String kubun) {
        this.kubun = kubun;
    }

    /**
     * @return the Shop
     */
    public Shop getShop() {
        return Shop;
    }

    /**
     * @param Shop the Shop to set
     */
    public void setShop(Shop Shop) {
        this.Shop = Shop;
    }

    /**
     * @return the flg
     */
    public boolean isKasidasiflg() {
        return kasidasiflg;
    }

    /**
     * @param flg the flg to set
     */
    public void setKasidasiflg(boolean flg) {
        this.kasidasiflg = flg;
    }

    /**
     * @return the haikiflg
     */
    public boolean isHaikiflg() {
        return haikiflg;
    }

    /**
     * @param haikiflg the haikiflg to set
     */
    public void setHaikiflg(boolean haikiflg) {
        this.haikiflg = haikiflg;
    }

    /**
     * @return the baitai
     */
    public String getBaitai() {
        return baitai;
    }

    /**
     * @param baitai the baitai to set
     */
    public void setBaitai(String baitai) {
        this.baitai = baitai;
    }
    
}
