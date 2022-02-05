package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.JobCreateDto;
import com.unasporcastoria.core.api.dto.JobUpdateDto;
import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
import com.unasporcastoria.core.api.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JobService extends BaseService<Job, Long> {


  @Autowired
  public JobService(JobRepository repository) {
    this.entityName = "Job";
    this.repository = repository;
  }

  public Page<Job> getJobs(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Job createJob(JobCreateDto jobDto) {
    var job = jobDto.toJob();
    return repository.save(job);
  }

  public Job update(Long id, JobUpdateDto job) {
    var j = this.get(id).orElseThrow(this::notFound);

    if (job.getId().equals(j.getId())) {
      job.toJob(j);
    } else {
      throw new USSException(Error.ID_MISMATCH);
    }

    return repository.save(j);
  }
}
