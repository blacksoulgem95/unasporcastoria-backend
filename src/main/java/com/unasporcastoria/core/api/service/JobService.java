package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.JobCreateDto;
import com.unasporcastoria.core.api.dto.JobUpdateDto;
import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
import com.unasporcastoria.core.api.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class JobService extends BaseService<Job, Long, JobRepository> {

  @Autowired
  public JobService(JobRepository repository) {
    this.entityName = "Job";
    this.repository = repository;
  }

  @Transactional
  public Page<Job> findAll(Pageable pageable, String name) {
    if (StringUtils.isNotBlank(name))
      return repository().findByNameContainingIgnoreCase(name, pageable);
    else return repository().findAll(pageable);
  }

  @Transactional
  public Job createJob(JobCreateDto jobDto) {
    var job = jobDto.toJob();
    return repository().save(job);
  }

  @Transactional
  public Job update(Long id, JobUpdateDto job) {
    var j = this.get(id).orElseThrow(this::notFound);

    if (job.getId().equals(j.getId())) {
      job.toJob(j);
    } else {
      throw new USSException(Error.ID_MISMATCH);
    }

    return repository().save(j);
  }
}
