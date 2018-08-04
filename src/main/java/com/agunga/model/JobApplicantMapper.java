package com.agunga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Created by agufed on 8/4/18.
 */
@Entity
public class JobApplicantMapper extends JobBaseModel {

    @OneToOne
    private Job job;

    @OneToMany
    private JobApplicant jobApplicant;

    @Column(name = "participate")
    private boolean participateInInterview;

    /*public void addApplicant(JobApplicant jobApplicant){
        this.jobApplicant.add(jobApplicant);
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }*/

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobApplicant getJobApplicant() {
        return jobApplicant;
    }

    public void setJobApplicant(JobApplicant jobApplicant) {
        this.jobApplicant = jobApplicant;
    }

    public boolean isParticipateInInterview() {
        return participateInInterview;
    }

    public void setParticipateInInterview(boolean participateInInterview) {
        this.participateInInterview = participateInInterview;
    }
}
