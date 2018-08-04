package com.agunga.model;

import com.agunga.myenum.EducationLevel;
import com.agunga.myenum.JobType;
import com.agunga.myenum.Status;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by agufed on 8/4/18.
 */
@Entity
@Table(name = "jobs")
public class Job extends JobBaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private JobType type;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    @Column(name = "education_level")
    private EducationLevel educationLevel;

    @Column(name = "status")
    private Status status;

    @UniqueElements
    @Column(name = "interview_date")
    private Date interviewDate;

    @Column(name = "interview_start_time")
    private ZonedDateTime interviewStartTime;

    @Column(name = "interview_end_time")
    private ZonedDateTime interviewEndTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public ZonedDateTime getInterviewStartTime() {
        return interviewStartTime;
    }

    public void setInterviewStartTime(ZonedDateTime interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }

    public ZonedDateTime getInterviewEndTime() {
        return interviewEndTime;
    }

    public void setInterviewEndTime(ZonedDateTime interviewEndTime) {
        this.interviewEndTime = interviewEndTime;
    }
}
