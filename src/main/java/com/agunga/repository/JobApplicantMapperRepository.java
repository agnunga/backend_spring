package com.agunga.repository;

import com.agunga.model.Job;
import com.agunga.model.JobApplicant;
import com.agunga.model.JobApplicantMapper;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
public interface JobApplicantMapperRepository extends CrudRepository<JobApplicantMapper, UUID> {

    List<JobApplicantMapper> findJobApplicantMappersByJob_Id(UUID job);

    List<JobApplicantMapper> findJobApplicantMappersByJobApplicant_IdAAndParticipateInInterview(UUID jobApplicant, boolean participate);

    List<JobApplicantMapper> findJobApplicantMappersByJob_IdAndAndParticipateInInterview(UUID jobApplicantId, boolean participate);

    List<JobApplicantMapper> findJobApplicantMappersByJob_IdAndAndJobApplicant_IdAndParticipateInInterview(UUID jobId, UUID applicantId, boolean participate);

    int countJobApplicantMappersByByJob_InterviewDateAndJob_Id(Date interviewDate, UUID jobId);

    int countJobApplicantMappersByJobApplicant_IdAndJob_InterviewDate(UUID applicant_id, Date interviewDate);

    int countJobApplicantMappersByJobApplicant_IdAndJob_InterviewStartTime_MinuteBetween(UUID applicant_id, ZonedDateTime interviewStartTime, ZonedDateTime interviewEndTime);

}
