package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.JobCreateDto;
import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/jobs")
@RequiredArgsConstructor
public class AdminJobsController {

  private final JobService jobService;

  @GetMapping
  public Page<Job> getJobs(Pageable pageable) {
    return jobService.getJobs(pageable);
  }

  @GetMapping("/{id}")
  public Job getJob(@PathVariable("id") Long id) {
    return jobService.getJob(id).orElseThrow(() -> new NotFoundException("Job"));
  }

  @PostMapping
  public Job createJob(@RequestBody JobCreateDto job) {
    return jobService.createJob(job);
  }

}
