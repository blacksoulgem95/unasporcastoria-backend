package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.JobCreateDto;
import com.unasporcastoria.core.api.dto.JobUpdateDto;
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
  public Page<Job> getJobs(@RequestParam(value = "name", required = false) String name,
                           Pageable pageable) {
    return jobService.getJobs(pageable, name);
  }

  @GetMapping("/{id}")
  public Job getJob(@PathVariable("id") Long id) {
    return jobService.get(id).orElseThrow(() -> new NotFoundException("Job"));
  }

  @PostMapping
  public Job createJob(@RequestBody JobCreateDto job) {
    return jobService.createJob(job);
  }

  @DeleteMapping("/{id}")
  public void deleteJob(@PathVariable("id") Long id) {
    jobService.delete(id);
  }

  @PutMapping("/{id}")
  public Job updateJob(@PathVariable("id") Long id, @RequestBody JobUpdateDto job) {
    return jobService.update(id, job);
  }
}
