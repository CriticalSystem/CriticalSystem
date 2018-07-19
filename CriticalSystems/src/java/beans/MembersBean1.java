/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.MembersDb1;
import entity.Members1;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author s20163045
 */
@Named
@ConversationScoped
public class MembersBean1 implements Serializable{
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
    private List<Members1> membersList;
    
    @EJB
    MembersDb1 membersdb1;
    
    public String list() {
        setMembersList(membersdb1.getAll());
        return "/memberlist.xhtml";
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
     * @return the membersList
     */
    public List<Members1> getMembersList() {
        return membersList;
    }

    /**
     * @param membersList the membersList to set
     */
    public void setMembersList(List<Members1> membersList) {
        this.membersList = membersList;
    }
}
