package com.agunga.repository;

import com.agunga.model.JobApplicant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
@Component
public interface JobApplicantRepository extends CrudRepository<JobApplicant, UUID> {

}
