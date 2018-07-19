/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.MembersDb;
import db.ReceiptDb;
import entity.Members;
import entity.Receipt;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author s20163045
 */
public class ReceiptBean {
    
    @NotNull
    private String slip_number;
    private Date lend_date;
    private int is_discount;
    private int totsl_price;
    private String emploees_code;
    private String members_code;
    private String store_code;
    private List<Receipt> receiptlist;
    
     @EJB
    private ReceiptDb receiptdb;
    
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
    
    public String test() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Receipt receipt = receiptdb.getMaxCode().get(0);
        
        setSlip_number(receipt.getSlip_number());
        setLend_date(receipt.getLend_date());
        setIs_discount(receipt.getIs_discount());
        return "testt.xhtml";
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
     * @return the lend_date
     */
    public Date getLend_date() {
        return lend_date;
    }

    /**
     * @param lend_date the lend_date to set
     */
    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    /**
     * @return the is_discount
     */
    public int getIs_discount() {
        return is_discount;
    }

    /**
     * @param is_discount the is_discount to set
     */
    public void setIs_discount(int is_discount) {
        this.is_discount = is_discount;
    }

    /**
     * @return the totsl_price
     */
    public int getTotsl_price() {
        return totsl_price;
    }

    /**
     * @param totsl_price the totsl_price to set
     */
    public void setTotsl_price(int totsl_price) {
        this.totsl_price = totsl_price;
    }

    /**
     * @return the emploees_code
     */
    public String getEmploees_code() {
        return emploees_code;
    }

    /**
     * @param emploees_code the emploees_code to set
     */
    public void setEmploees_code(String emploees_code) {
        this.emploees_code = emploees_code;
    }

    /**
     * @return the members_code
     */
    public String getMembers_code() {
        return members_code;
    }

    /**
     * @param members_code the members_code to set
     */
    public void setMembers_code(String members_code) {
        this.members_code = members_code;
    }

    /**
     * @return the store_code
     */
    public String getStore_code() {
        return store_code;
    }

    /**
     * @param store_code the store_code to set
     */
    public void setStore_code(String store_code) {
        this.store_code = store_code;
    }

    /**
     * @return the receiptlist
     */
    public List<Receipt> getReceiptlist() {
        return receiptlist;
    }

    /**
     * @param receiptlist the receiptlist to set
     */
    public void setReceiptlist(List<Receipt> receiptlist) {
        this.receiptlist = receiptlist;
    }

    /**
     * @return the receiptdb
     */
    public ReceiptDb getReceiptdb() {
        return receiptdb;
    }

    /**
     * @param receiptdb the receiptdb to set
     */
    public void setReceiptdb(ReceiptDb receiptdb) {
        this.receiptdb = receiptdb;
    }
}
