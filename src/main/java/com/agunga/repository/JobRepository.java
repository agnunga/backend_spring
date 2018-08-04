package com.agunga.repository;

import com.agunga.model.Job;
import com.agunga.myenum.JobType;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
public interface JobRepository extends CrudRepository<Job, UUID> {

    List<Job> findJobsByInterviewDate(Date date);

    List<Job> findJobsByNameContaining(String search);

    List<Job> findJobsByDescriptionContaining(String desc);

    List<Job> findJobsByType(JobType jobType);

};
