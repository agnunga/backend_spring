package com.agunga.service;

import com.agunga.model.JobApplicant;
import com.agunga.model.JobApplicantMapper;
import com.agunga.repository.JobApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
@Service
public class JobApplicantService {

    private final JobApplicantRepository repository;

    @Autowired
    public JobApplicantService(JobApplicantRepository repository) {
        this.repository = repository;
    }


    public JobApplicant create(JobApplicant jobApplicant) {
        return repository.save(jobApplicant);
    }


    public void delete(JobApplicant jobApplicant) throws Exception{
        repository.delete(jobApplicant);
    }

    public JobApplicant findById(UUID id) {
        Optional<JobApplicant> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<JobApplicant> findAll() {
        return (List<JobApplicant>) repository.findAll();
    }

}
