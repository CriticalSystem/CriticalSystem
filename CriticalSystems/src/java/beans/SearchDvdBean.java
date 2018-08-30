package beans;

import db.MembersDb;
import db.TempMemberDb;
import entity.Members;
import entity.TempMember;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@ConversationScoped
public class SearchDvdBean implements Serializable{
    
    private final static Map<String ,Integer>items_g;
    
    public Map<String,Integer>getItems_g(){
        return items_g;
    }
    static{
        items_g=new LinkedHashMap<>();
        items_g.put("すべてのジャンル　　　　　　　　　　　　　　　　　　　　　　　　　　",0);
        items_g.put("アニメ",10);
        items_g.put("洋画",11);
        items_g.put("邦画",12);
        items_g.put("スポーツ",13);
    }
    
    private String keyWord;         //検索ワード
    private Integer genre_i;        //検索ジャンル
    private Integer media_i;        //検索メディア（0＝指定なし,1=bd,2=dvd）
    
    @Inject
    Conversation conv;
    @Inject
    transient Logger log;
    
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
    public Integer getGenre_i() {
        return genre_i;
    }
    
    public void setGenre_i(Integer genre_i) {
        this.genre_i = genre_i;
    }
    
    public Integer getMedia_i() {
        return media_i;
    }

    public void setMedia_i(Integer media_i) {
        this.media_i = media_i;
    }
    
    public Conversation getConv() {
        return conv;
    }

    public void setConv(Conversation conv) {
        this.conv = conv;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }
    
    public String next(){
        if(conv.isTransient()) {
            conv.begin();
        }
        log.info("anan");
        
        return "searchresult.xhtml";
    }
}
