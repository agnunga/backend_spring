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
@RequestMapping("/search")
public class SearchController {

    private final JobService service;

    @Autowired
    public SearchController(JobService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{search_by}/{search_phrase}", method = RequestMethod.GET)
    public List<Job> read(@PathVariable String search_by, @PathVariable String search_phrase){
        return service.seachJobs (search_by, search_phrase);
    }

}
