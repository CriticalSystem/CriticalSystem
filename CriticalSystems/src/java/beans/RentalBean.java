/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.DiscDb;
import db.MembersDb;
import db.ReceiptDb;
import db.TitleDb;
import entity.Disc;
import entity.Members;
import entity.Receipt;
import entity.ReceiptDetails;
import entity.Title;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    
    //会員情報
    private String member_code;     //会員番号
    private String name;            //名前
    private Date birthday;          //誕生日
    private Date join_date;         //入会日
    private Date defect_date;       //退会日
    private String member_state;    //会員状態
    private String discount_number; //割引番号
    private long age;             //年齢
    //ディスク情報
    private String disc_code;       //ディスク番号
    private Date arrival_date;      //入荷日
    private String is_disposal;     //廃棄フラグ
    private String is_lend;         //貸出フラグ
    private String media;           //媒体
    private String rack;            //棚番号
    private String div_code;        //種類
    private String title_code;      //タイトル番号
    private String title_name;      //タイトル名
    private List<Disc> disclist = new ArrayList<>();
    private int cnt;
    //レシート情報
    private Receipt receipt;
    private String slip_number;     //レシート番号
////    private String members_code;    //会員番号
//    private String employees_code;  //店員番号
//    private String store_code;      //店舗番号
//    private Date lend_date;         //貸出日
//    private int total_price;     //合計金額
    private boolean is_discount = false;     //割引フラグ
    private int discount;
    //レシート明細情報
//    private String slip_number;   //レシート番号
    private String serial_number;  //明細番号
//    private String disc_code;     //ディスク番号
    private int div_date;        //期間
    private String div_sel;         //当日１泊・・
    private String div_name;        //新作準新作旧作
    private Date return_date;       //返却日
    private String due_date;  //返却予定日
    private String late_price;      //延滞料金
    private int price;
    private List<ReceiptDetails> receiptminlist = new ArrayList<>();
    private int subtotal = 0;           //小計
    private int tax;
    private int total;
    private int azukari;            //預かり金
    private int oturi;             //おつり
    private List<String> list = new ArrayList<>();
    
//    private static Map<String ,Integer>divmap1;
//    private static Map<String ,Integer>divmap2;
//    private static Map<String ,Integer>divmap3;
    
    
    @EJB
    ReceiptDb receiptdb;
    @EJB
    MembersDb membersdb;
    @EJB
    DiscDb discdb;
    @EJB
    TitleDb titledb;
    
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
    
    public String setDivdate0(){
        setDiv_sel("当日");
        setDiv_date(0);
        due_date = calcDate(div_date);
        setPrice(200);
        log.info("当日");
        addDetails();
        return null;
    }
    
    public String setDivdate1(){
        setDiv_sel("1泊2日");
        setDiv_date(1);
        setPrice(200);
        due_date = calcDate(div_date);
        addDetails();
        return null;
    }
    
    public String setDivdate2(){
        setDiv_sel("2泊3日");
        setDiv_date(2);
        setPrice(300);
        due_date = calcDate(div_date);
        addDetails();
        return null;
    }
    
    public String setDivdate7(){
        setDiv_sel("7泊8日");
        setDiv_date(7);
        setPrice(160);
        due_date = calcDate(div_date);
        addDetails();
        return null;
    }
    
    public String addDetails(){
        receiptminlist.remove(receiptminlist.size() -1);
        ReceiptDetails receipt = new ReceiptDetails();
        receipt.setDisc_code(disc_code);
        receipt.setDue_date(due_date);
        receipt.setPrice(price);
        receipt.setSerial_number(cnt);
        receipt.setDiv_sel(div_sel);
        receiptminlist.add(receipt);
        subtotal += price;
        total = subtotal + getTax();
        return null;
    }
    
    public int tax(int subtotal){
        setTax((int)(subtotal * 0.08));
        return getTax();
    }
    
    public String discount(){
        if(is_discount){
            total += 50;
            discount = 0;
            is_discount = false;
        }else{
            total -= 50;
            discount = -50;
            is_discount = true;
        }
        return null;
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
        setBirthday(members.getBirthday());
        setMember_state(members.getStats());
        Date now = new Date();
        setAge(calcAge(birthday,now));
        return "rental2.xhtml";
    }
    
    public String gettitle(String disc_code) {
        if(conv.isTransient()) {
            conv.begin();
        }
        Disc disc = discdb.find(disc_code);
        Title title = titledb.find(disc.getTitle_code());
        setTitle_name(title.getTitle_Name());
        return title_name;
    }
    
    public String getMedia(String disc_code){
        if(conv.isTransient()) {
            conv.begin();
        }
        Disc disc = discdb.find(disc_code);
        media = disc.getMedia();
        return media;
    }
    
    public String discadd() {
        if(conv.isTransient()) {
            conv.begin();
        }
        if(member_state.equals("通常会員")){
            Disc disc = discdb.find(disc_code);
            disclist.add(disc);
            getList().add(disc_code);
            cnt = disclist.size(); 
            ReceiptDetails receipt = new ReceiptDetails();
            receipt.setSerial_number(cnt);
            receipt.setDisc_code(disc_code);
            receiptminlist.add(receipt);
        }else{
            
        }
        return null;
    }
    
    public static int calcAge(Date birthday, Date now) {
        int age = now.getYear() - birthday.getYear();
        if (now.getMonth() < birthday.getMonth()) {
            age--;
        } else if (now.getMonth() == birthday.getMonth()) {
            if (now.getDay() < birthday.getDay()) {
                age--;
            }
        }
        return age;
    }
    
    public String calcDate(int div_date) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, div_date);
        Date reday = calendar.getTime();
        String day = sdf.format(reday);
        setDue_date(day);
        return day;
    }
    
    
//    public String execCreate() {
//        log.info(log.getName() + " | イベント登録処理");
//        slip_number = CreateSlipNumber();
//        receipt= new Receipt(slip_number);
//        String store_code = "102";
//        int total_price = 780;
////        receipt.setStore_code(store_code);
//        receipt.setTotal_price(total_price);
//        receipt.setMembers_code(member_code);
//        try {
//            receiptdb.create(receipt);
//        } catch (Exception e) {
//            log.fine("■" + log.getName() + "|" + e.getMessage());
//        }
//        log.info(log.getName() + " | 会話スコープ終了");
//        conv.end();
//        return "rental1.xhtml";
//    }
    
    public String CreateSlipNumber(){
        slip_number = "1234567890";
        return slip_number;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.log);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RentalBean other = (RentalBean) obj;
        if (!Objects.equals(this.log, other.log)) {
            return false;
        }
        return true;
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
     * @return the receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * @param receipt the receipt to set
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
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
     * @return the receiptminlist
     */
    public List<ReceiptDetails> getReceiptminlist() {
        return receiptminlist;
    }

    /**
     * @param receiptminlist the receiptminlist to set
     */
    public void setReceiptminlist(List<ReceiptDetails> receiptminlist) {
        this.receiptminlist = receiptminlist;
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
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    /**
     * @return the div_name
     */
    public String getDiv_name() {
        return div_name;
    }

    /**
     * @param div_name the div_name to set
     */
    public void setDiv_name(String div_name) {
        this.div_name = div_name;
    }

    /**
     * @return the div_date
     */
    public int getDiv_date() {
        return div_date;
    }

    /**
     * @param div_date the div_date to set
     */
    public void setDiv_date(int div_date) {
        this.div_date = div_date;
    }

    /**
     * @return the due_date
     */
    public String getDue_date() {
        return due_date;
    }

    /**
     * @param due_date the due_date to set
     */
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the is_discount
     */
    public boolean isIs_discount() {
        return is_discount;
    }

    /**
     * @param is_discount the is_discount to set
     */
    public void setIs_discount(boolean is_discount) {
        this.is_discount = is_discount;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the tax
     */
    public int getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(int tax) {
        this.tax = tax;
    }

    /**
     * @return the div_sel
     */
    public String getDiv_sel() {
        return div_sel;
    }

    /**
     * @param div_sel the div_sel to set
     */
    public void setDiv_sel(String div_sel) {
        this.div_sel = div_sel;
    }
}
