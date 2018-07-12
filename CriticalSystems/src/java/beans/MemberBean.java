/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.MemberDb;
import entity.Member;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author s20163048
 */
public class MemberBean {
    
    private Member member;
    
    @EJB
    MemberDb memberDb;
    @Inject
    transient Logger log;
    @Inject
    Conversation conv;
    
    @PostConstruct
    public void start(){
        if(!conv.isTransient()) {
            log.info(log.getName() + " | 会話スコープ終了");
            conv.end();
        }
    }
       
    
    
        
}
