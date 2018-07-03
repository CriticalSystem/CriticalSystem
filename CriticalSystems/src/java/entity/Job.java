/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * 職業
 */

@Entity
@NamedQuery(name = "Job.JobQAll" , query = "SELECT e FROM Job")
public class Job implements Serializable{
    public static final String JobQAll = "JobQAll";
    
    @Id
    private String jobCD;
    
    private String jobName;

    /**
     * @return the jobCD
     */
    public String getJobCD() {
        return jobCD;
    }

    /**
     * @param jobCD the jobCD to set
     */
    public void setJobCD(String jobCD) {
        this.jobCD = jobCD;
    }

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
}
