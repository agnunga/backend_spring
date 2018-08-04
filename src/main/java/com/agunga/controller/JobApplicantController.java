package com.agunga.controller;

import com.agunga.model.Job;
import com.agunga.model.JobApplicant;
import com.agunga.model.JobApplicantMapper;
import com.agunga.service.JobApplicantMapperService;
import com.agunga.service.JobApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
@RestController
@RequestMapping("/applicant")
public class JobApplicantController {

    private final JobApplicantService service;

    private final JobApplicantMapperService mapperService;

    @Autowired
    public JobApplicantController(JobApplicantService service, JobApplicantMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JobApplicant create(@RequestBody JobApplicant jobApplicant){
        return service.create(jobApplicant);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public JobApplicant update(@RequestBody JobApplicant jobApplicant){
        return service.create(jobApplicant);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody JobApplicant jobApplicant) throws Exception {
        service.delete(jobApplicant);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public JobApplicant read(@PathVariable UUID id){
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<JobApplicant> read(){
        return service.findAll();
    }

    /*c) Apply for a job And opt to attend interview */
    /*Task 2. a) First Come first Serve*/
    /*Task 2. b)*/
    @RequestMapping(value = "/apply/{applicant_id}/{job_id}", method = RequestMethod.POST)
    public JobApplicantMapper applyForAJob(@PathVariable UUID applicant_id, @PathVariable UUID job_id) throws Exception{
        return mapperService.applyJob(applicant_id, job_id);
    }

    /*d) enabe or disable interview participation //Does not delete the record*/
    @RequestMapping(value = "/participate/{applicant_id}/{job_id}/{participate}", method = RequestMethod.GET)
    public JobApplicantMapper participateInInterview(@PathVariable UUID applicant_id, @PathVariable UUID job_id, @PathVariable boolean participate){
        return mapperService.participate(applicant_id, job_id, participate);
    }

    /*e) List jobs interviews an applicant has enrolled for. */
    @RequestMapping(value = "/jobs/{applicant_id}/", method = RequestMethod.GET)
    public List<Job> listJobInterviews(@PathVariable UUID applicant_id){
        return mapperService.findJobsByApplicants(applicant_id);
    }

    /*f) List interview participants for a given job. */
    @RequestMapping(value = "/applicants/{job_id}", method = RequestMethod.GET)
    public List<JobApplicant> findApplicantsByJob(@PathVariable UUID job_id){
        return mapperService.findApplicantsByJob(job_id);
    }

}
