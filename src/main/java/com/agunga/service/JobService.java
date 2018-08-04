package com.agunga.service;

import com.agunga.model.Job;
import com.agunga.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */

@Service
public class JobService {

    private final JobRepository repository;

    @Autowired
    public JobService(JobRepository repository) {
        this.repository = repository;
    }


    public Job create(Job Job) {
        return repository.save(Job);
    }

    public void delete(Job Job) throws Exception{
        repository.delete(Job);
    }

    public Job findById(UUID id) {
        Optional<Job> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<Job> findAll() {
        return (List<Job>) repository.findAll();
    }

}
