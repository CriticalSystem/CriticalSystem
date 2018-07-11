package beans;

import db.DiscDb;
import entity.Disc;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@ViewScoped
public class DiscBean implements Serializable {

    @NotNull
    private String Disc_code;
    private String Title_code;
    private String Arraival_date;
    private String Is_lend;
    private String Is_disposal;
    private String Media;
    private String Store_code;
    private String Rack_code;
    private String Div_code;
    
    @EJB
    DiscDb db;
    @Inject
    transient Logger log;

    public String create() {
        Disc disc = new Disc();
        try {
            db.create(disc);
        } catch (Exception e) {
            log.fine("■" + Disc_code + "|" + e.getMessage());
        }
        return null;
    }

    public String edit(Disc disc) {	// 編集データのセット
        num = disc.getNum();
        name = disc.getName();
        mail = disc.getMail();
        return null;
    }

    public String update() {	// 更新
        Disc disc = new Disc(num,name,mail);
        try {
            db.update(disc);
            clear();
        } catch (Exception e) {
            log.fine("■" + disc_code + "|" + e.getMessage());
        }
        return null;
    }

    public String delete(Disc disc) {	// 削除
        db.delete(disc);
        return null;
    }

    public String find() {						// 検索
        Disc m = db.find(Disc_code);
        if(m != null) {
            this.Disc_code = m.getDisc_code();
            this.Title_code = m.getTitle_code();
            this.Arraival_date = m.getArraival_date();
            this.Is_lend = m.getIs_lend();
            this.Is_disposal = m.getIs_disposal();
            this.Media = m.getMedia();
            this.Store_code = m.getStore_code();
            this.Rack_code = m.getRack_code();
            this.Store_code = m.getStore_code();
        }
        return null;
    }
    
    public List<Disc> getAll() {	// 全データをListにいれて返す
        return db.getAll();
    }
    
    public String getDisc_code() {
        return Disc_code;
    }

    public void setDisc_code(String Disc_code) {
        this.Disc_code = Disc_code;
    }

    public String getTitle_code() {
        return Title_code;
    }

    public void setTitle_code(String Title_code) {
        this.Title_code = Title_code;
    }

    public String getArraival_date() {
        return Arraival_date;
    }

    public void setArraival_date(String Arraival_date) {
        this.Arraival_date = Arraival_date;
    }

    public String getIs_lend() {
        return Is_lend;
    }

    public void setIs_lend(String Is_lend) {
        this.Is_lend = Is_lend;
    }

    public String getIs_disposal() {
        return Is_disposal;
    }

    public void setIs_disposal(String Is_disposal) {
        this.Is_disposal = Is_disposal;
    }

    public String getMedia() {
        return Media;
    }

    public void setMedia(String Media) {
        this.Media = Media;
    }

    public String getStore_code() {
        return Store_code;
    }

    public void setStore_code(String Store_code) {
        this.Store_code = Store_code;
    }

    public String getRack_code() {
        return Rack_code;
    }

    public void setRack_code(String Rack_code) {
        this.Rack_code = Rack_code;
    }

    public String getDiv_code() {
        return Div_code;
    }

    public void setDiv_code(String Div_code) {
        this.Div_code = Div_code;
    }

    public DiscDb getDb() {
        return db;
    }

    public void setDb(DiscDb db) {
        this.db = db;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {    
        this.log = log;
    }

}
