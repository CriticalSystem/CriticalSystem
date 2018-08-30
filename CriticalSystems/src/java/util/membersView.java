/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import db.MembersDb;
import entity.Members;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="membersView")
@ViewScoped
public class membersView implements Serializable {
     
    private List<Members> membersList;
     
    private List<Members> filteredMembersList;
    @EJB
    MembersDb membersdb;
     
//    @ManagedProperty("#{carService}")
//    private CarService service;
// 
    
            
    @PostConstruct
    public void init() {
        setMembersList(membersdb.getAll());
    }
     
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    /**
     * @return the membersList
     */
    public List<Members> getMembersList() {
        return membersList;
    }

    /**
     * @param membersList the membersList to set
     */
    public void setMembersList(List<Members> membersList) {
        this.membersList = membersList;
    }

    /**
     * @return the filteredMembersList
     */
    public List<Members> getFilteredMembersList() {
        return filteredMembersList;
    }

    /**
     * @param filteredMembersList the filteredMembersList to set
     */
    public void setFilteredMembersList(List<Members> filteredMembersList) {
        this.filteredMembersList = filteredMembersList;
    }

    
}