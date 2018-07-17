/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.MembersDb;
import entity.Members;
import java.io.Serializable;
import javax.ejb.EJB;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;

@Named
@SessionScoped
public class MembersListBean implements Serializable {
    
    private List<Members> membersList;
    
    @EJB
    MembersDb membersDb;
    @Inject
    transient Logger log;
    
    public String list() {
        log.info(log.getName() + " | イベント一覧画面");
        membersList = membersDb.getAll();
        return "/memberlist.xhtml";
    }
    
//    public String update(Members obj) {
//        log.info(log.getName() + " | イベント更新処理");
//        Members members = new Members(obj.getMembersId(), obj.getMembersName());
//        try {
//            membersDb.update(members);
//        } catch (Exception e) {
//            log.fine("■" + log.getName() + "|" + e.getMessage());
//        }
//        membersList = membersDb.getAll();
//        return null;
//    }
    
    public String delete(Members obj) {
        log.info(log.getName() + " | イベント削除処理");
        try {
            membersDb.delete(obj);
        } catch (Exception e) {
            log.fine("■" + log.getName() + "|" + e.getMessage());
        }
        membersList = membersDb.getAll();
        return null;
            
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.membersList);
        hash = 17 * hash + Objects.hashCode(this.membersDb);
        hash = 17 * hash + Objects.hashCode(this.log);
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
        final MembersListBean other = (MembersListBean) obj;
        if (!Objects.equals(this.membersList, other.membersList)) {
            return false;
        }
        if (!Objects.equals(this.membersDb, other.membersDb)) {
            return false;
        }
        if (!Objects.equals(this.log, other.log)) {
            return false;
        }
        return true;
    }

    public List<Members> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Members> membersList) {
        this.membersList = membersList;
    }

    public MembersDb getMembersDb() {
        return membersDb;
    }

    public void setMembersDb(MembersDb membersDb) {
        this.membersDb = membersDb;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    } 
}
