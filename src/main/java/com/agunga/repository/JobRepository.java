package com.agunga.repository;

import com.agunga.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by agufed on 8/4/18.
 */
public interface JobRepository extends CrudRepository<Job, UUID> {

}
