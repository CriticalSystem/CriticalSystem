/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author s20163045
 */
@Entity
@Table(name="RENTAL")
public class Rental implements Serializable{
    
    @Id
    @Column(name = "meber_code")
    private String member_code;     //会員番号
    @Column(name = "name")
    private String name;            //名前
    @Column(name = "birthday")
    private Date birthday;          //誕生日
    @Column(name = "join_date")
    private Date join_date;         //入会日
    @Column(name = "defect_date")
    private Date defect_date;       //退会日
    @Column(name = "member_state")
    private String member_state;    //会員状態
    @Column(name = "discount_number")
    private String discount_number; //割引番号
    @Column(name = "age")
    private long age;             //年齢
    @Column(name = "disc_code")
    private String disc_code;       //ディスク番号
    @Column(name = "arrival_date")
    private Date arrival_date;      //入荷日
    @Column(name = "is_disposal")
    private String is_disposal;     //廃棄フラグ
    @Column(name = "is_lend")
    private String is_lend;         //貸出フラグ
    @Column(name = "disc_code")
    private String media;           //媒体
    @Column(name = "rack")
    private String rack;            //棚番号
    @Column(name = "div_code")
    private String div_code;        //種類
    @Column(name = "title_code")
    private String title_code;      //タイトル番号
    @Column(name = "title_name")
    private String title_name;      //タイトル名
    
    @Column(name = "cnt")
    private int cnt;
    
    @Column(name = "slip_number")
    private String slip_number;     //レシート番号
    @Column(name = "serial_number")
    private String serial_number;  //明細番号
    
    @Column(name = "return_date")
    private Date return_date;       //返却日
    @Column(name = "return_plan_date")
    private Date return_plan_date;  //返却予定日
    @Column(name = "late_price")
    private String late_price;      //延滞料金
    @Column(name = "subtotal")
    private int subtotal;           //小計
    @Column(name = "azukari")
    private int azukari;            //預かり金
    @Column(name = "oturi")
    private int oturi;             //おつり

    /**
     * @return the member_code
     */
    public String getMember_code() {
        return member_code;
    }

    /**
     * @param member_code the member_code to set
     */
    public void setMember_code(String member_code) {
        this.member_code = member_code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the join_date
     */
    public Date getJoin_date() {
        return join_date;
    }

    /**
     * @param join_date the join_date to set
     */
    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    /**
     * @return the defect_date
     */
    public Date getDefect_date() {
        return defect_date;
    }

    /**
     * @param defect_date the defect_date to set
     */
    public void setDefect_date(Date defect_date) {
        this.defect_date = defect_date;
    }

    /**
     * @return the member_state
     */
    public String getMember_state() {
        return member_state;
    }

    /**
     * @param member_state the member_state to set
     */
    public void setMember_state(String member_state) {
        this.member_state = member_state;
    }

    /**
     * @return the discount_number
     */
    public String getDiscount_number() {
        return discount_number;
    }

    /**
     * @param discount_number the discount_number to set
     */
    public void setDiscount_number(String discount_number) {
        this.discount_number = discount_number;
    }

    /**
     * @return the age
     */
    public long getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(long age) {
        this.age = age;
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
     * @return the arrival_date
     */
    public Date getArrival_date() {
        return arrival_date;
    }

    /**
     * @param arrival_date the arrival_date to set
     */
    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    /**
     * @return the is_disposal
     */
    public String getIs_disposal() {
        return is_disposal;
    }

    /**
     * @param is_disposal the is_disposal to set
     */
    public void setIs_disposal(String is_disposal) {
        this.is_disposal = is_disposal;
    }

    /**
     * @return the is_lend
     */
    public String getIs_lend() {
        return is_lend;
    }

    /**
     * @param is_lend the is_lend to set
     */
    public void setIs_lend(String is_lend) {
        this.is_lend = is_lend;
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
     * @return the rack
     */
    public String getRack() {
        return rack;
    }

    /**
     * @param rack the rack to set
     */
    public void setRack(String rack) {
        this.rack = rack;
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
     * @return the title_name
     */
    public String getTitle_name() {
        return title_name;
    }

    /**
     * @param title_name the title_name to set
     */
    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    /**
     * @return the cnt
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * @param cnt the cnt to set
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * @return the slip_number
     */
    public String getSlip_number() {
        return slip_number;
    }

    /**
     * @param slip_number the slip_number to set
     */
    public void setSlip_number(String slip_number) {
        this.slip_number = slip_number;
    }

    /**
     * @return the serial_number
     */
    public String getSerial_number() {
        return serial_number;
    }

    /**
     * @param serial_number the serial_number to set
     */
    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    /**
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    /**
     * @return the return_plan_date
     */
    public Date getReturn_plan_date() {
        return return_plan_date;
    }

    /**
     * @param return_plan_date the return_plan_date to set
     */
    public void setReturn_plan_date(Date return_plan_date) {
        this.return_plan_date = return_plan_date;
    }

    /**
     * @return the late_price
     */
    public String getLate_price() {
        return late_price;
    }

    /**
     * @param late_price the late_price to set
     */
    public void setLate_price(String late_price) {
        this.late_price = late_price;
    }

    /**
     * @return the subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the azukari
     */
    public int getAzukari() {
        return azukari;
    }

    /**
     * @param azukari the azukari to set
     */
    public void setAzukari(int azukari) {
        this.azukari = azukari;
    }

    /**
     * @return the oturi
     */
    public int getOturi() {
        return oturi;
    }

    /**
     * @param oturi the oturi to set
     */
    public void setOturi(int oturi) {
        this.oturi = oturi;
    }
    
}
