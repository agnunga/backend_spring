package com.agunga.service;

import com.agunga.exception.JobConflictException;
import com.agunga.exception.MaximumJobsAppliedException;
import com.agunga.exception.MaximumJobsParticipantsException;
import com.agunga.model.Job;
import com.agunga.model.JobApplicant;
import com.agunga.model.JobApplicantMapper;
import com.agunga.repository.JobApplicantMapperRepository;
import com.agunga.repository.JobApplicantRepository;
import com.agunga.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */

@Service
public class JobApplicantMapperService {

    private final JobApplicantMapperRepository repository;

    private final JobRepository jobRepository;

    private final JobApplicantRepository applicantRepository;

    @Autowired
    public JobApplicantMapperService(JobApplicantMapperRepository repository, JobApplicantRepository applicantRepository, JobRepository jobRepository) {
        this.repository = repository;
        this.applicantRepository = applicantRepository;
        this.jobRepository = jobRepository;
    }

    public JobApplicantMapper create(JobApplicantMapper jobApplicantMapper) {
        return repository.save(jobApplicantMapper);
    }


    public void delete(JobApplicantMapper jobApplicantMapper) throws Exception{
        repository.delete(jobApplicantMapper);
    }

    public JobApplicantMapper findById(UUID id) {
        Optional<JobApplicantMapper> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<JobApplicantMapper> findAll() {
        return (List<JobApplicantMapper>) repository.findAll();
    }

    public List<JobApplicant> findApplicantsByJob(UUID jobId) {
        List<JobApplicantMapper> jobApplicantsMappers = repository.findJobApplicantMappersByJob_IdAndAndParticipateInInterview(jobId, true);

        List<JobApplicant> jobApplicants = new ArrayList<>();
        if(jobApplicantsMappers != null && jobApplicantsMappers.size() > 0) {
            for (JobApplicantMapper jobApplicantMapper : jobApplicantsMappers) {
                jobApplicants.add(jobApplicantMapper.getJobApplicant());
            }
        }
        return jobApplicants;
    }

    public List<Job> findJobsByApplicants(UUID applicantId) {
        List<JobApplicantMapper> jobApplicantsMappers = repository.findJobApplicantMappersByJobApplicant_IdAAndParticipateInInterview(applicantId, true);

        List<Job> jobs = new ArrayList<>();
        if(jobApplicantsMappers != null && jobApplicantsMappers.size() > 0) {
            for (JobApplicantMapper jobApplicantMapper : jobApplicantsMappers) {
                jobs.add(jobApplicantMapper.getJob());
            }
        }
        return jobs;
    }

    public JobApplicantMapper applyJob(UUID applicant_id, UUID job_id) throws Exception {

        Job job = jobRepository.findById(job_id).get();
        /*Find if a job has more than 20 participants*/
        if(repository.countJobApplicantMappersByByJob_InterviewDateAndJob_Id(job.getInterviewDate(), job_id) >= 20){
            throw new MaximumJobsParticipantsException();
        }

        /*Ensure the applicant has not more than 3 interviews on the same Day*/
        if(repository.countJobApplicantMappersByJobApplicant_IdAndJob_InterviewDate(applicant_id, job.getInterviewDate()) >= 3){
            throw new MaximumJobsAppliedException();
        }

        /*Ensure the start and end time of the interviews do not overlap*/
        if(repository.countJobApplicantMappersByJobApplicant_IdAndJob_InterviewStartTime_MinuteBetween(applicant_id, job.getInterviewStartTime(), job.getInterviewEndTime()) > 0)
            throw new JobConflictException();

        JobApplicantMapper jobApplicantMapper = new JobApplicantMapper();

        jobApplicantMapper.setJobApplicant(applicantRepository.findById(applicant_id).get());
        jobApplicantMapper.setJob(jobRepository.findById(job_id).get());
        jobApplicantMapper.setParticipateInInterview(true);

        return repository.save(jobApplicantMapper);
    }

    public JobApplicantMapper participate(UUID applicant_id, UUID job_id, boolean participate) {

        List<JobApplicantMapper> jobApplicantMappers =  repository.findJobApplicantMappersByJob_IdAndAndJobApplicant_IdAndParticipateInInterview(job_id, applicant_id, true);
        if(jobApplicantMappers != null && jobApplicantMappers.size() > 0) {
            JobApplicantMapper jobApplicantMapper = jobApplicantMappers.get(0);
            jobApplicantMapper.setParticipateInInterview(false);
            return repository.save(jobApplicantMapper);
        }
        return null;

    }

}
