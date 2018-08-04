package com.agunga.controller;

import com.agunga.model.Job;
import com.agunga.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService service;

    @Autowired
    public JobController(JobService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Job create(@RequestBody Job job){
        return service.create(job);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Job read(@PathVariable UUID id){
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Job update(@RequestBody Job job) {
        return service.create(job);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Job job) throws Exception {
        service.delete(job);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Job> read(){
        return service.findAll();
    }

}
