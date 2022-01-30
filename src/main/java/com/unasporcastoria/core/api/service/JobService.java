package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.JobCreateDto;
import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.exception.WrongFileTypeException;
import com.unasporcastoria.core.api.repository.JobRepository;
import com.unasporcastoria.core.api.service.storage.FirebaseStorageService;
import com.unasporcastoria.core.api.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobService extends BaseService {

  private final JobRepository jobRepository;

  {
    this.entityName = "Job";
  }

  public Page<Job> getJobs(Pageable pageable) {
    return jobRepository.findAll(pageable);
  }

  public Optional<Job> getJob(Long id) {
    return jobRepository.findById(id);
  }

  public Job createJob(JobCreateDto jobDto) {
    var job = jobDto.toJob();
    return jobRepository.save(job);
  }

}
