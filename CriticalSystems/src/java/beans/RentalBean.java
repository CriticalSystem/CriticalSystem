/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.DiscDb;
import db.MembersDb;
import db.ReceiptDb;
import entity.Disc;
import entity.Members;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163045
 */
@Named
@ConversationScoped
public class RentalBean implements Serializable{
    
    
    private String member_code;
    private String name;
    private String name_ruby;
    private String sex;
    private Date birthday;
    private String postal_code;
    private String address;
    private String tel_number;
    private String email;
    private String is_magazine;
    private Date join_date;
    private Date defect_date;
    private String member_state;
    private String job_code;
    private String discount_number;
    private String disc_code;
    private Date arrival_date;
    private String is_disposal;
    private String is_lend;
    private String media;
    private String serial;
    private String div_code;
    private String title_code;
    private List<Disc> disclist = new ArrayList<>();
    
    @EJB
    ReceiptDb receiptdb;
    @EJB
    MembersDb membersdb;
    @EJB
    DiscDb discdb;
    
    @Inject
    transient Logger log;
    
    @Inject
    Conversation conv;

    @PostConstruct
    public void start(){
        if(!conv.isTransient()){
            log.info(log.getName() + "｜会話スコープ終了");
            conv.end();
        }
    }
    
    public String create() {
        log.info(log.getName() + " | イベント登録画面 ");
        if(conv.isTransient()) {
            conv.begin();
        }
        return "/pages/member/create.xhtml";
    }
    
    public String confirm() {
        log.info(log.getName() + " | イベント登録確認画面");
        return "confirm.xhtml";
    }

//    public String delete(Members member) {	// 削除
//        membersdb.delete(member);
//        return "削除完了画面パス";
//    }
//    
    
    public String memberget() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Members members = membersdb.find(member_code);
        
        setMember_code(members.getMembersCD());
        setName(members.getName());
        setAddress(members.getAddress());
        return "rental2.xhtml";
    }
    
    public String discadd() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Disc disc = discdb.find(disc_code);
//        disclist = discdb.find(getDisc_code());
        
        setDisc_code(disc.getDisc_code());
        setTitle_code(disc.getTitle_code());
        setMedia(disc.getMedia());
        return null;
    }

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
     * @return the name_ruby
     */
    public String getName_ruby() {
        return name_ruby;
    }

    /**
     * @param name_ruby the name_ruby to set
     */
    public void setName_ruby(String name_ruby) {
        this.name_ruby = name_ruby;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return the postal_code
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * @param postal_code the postal_code to set
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tel_number
     */
    public String getTel_number() {
        return tel_number;
    }

    /**
     * @param tel_number the tel_number to set
     */
    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the is_magazine
     */
    public String getIs_magazine() {
        return is_magazine;
    }

    /**
     * @param is_magazine the is_magazine to set
     */
    public void setIs_magazine(String is_magazine) {
        this.is_magazine = is_magazine;
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
     * @return the job_code
     */
    public String getJob_code() {
        return job_code;
    }

    /**
     * @param job_code the job_code to set
     */
    public void setJob_code(String job_code) {
        this.job_code = job_code;
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
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
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
     * @return the disclist
     */
    public List<Disc> getDisclist() {
        return disclist;
    }

    /**
     * @param disclist the disclist to set
     */
    public void setDisclist(List<Disc> disclist) {
        this.disclist = disclist;
    }
}
