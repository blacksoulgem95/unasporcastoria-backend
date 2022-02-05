package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class JobUpdateDto extends JobCreateDto{
  protected Long id;

  @JsonIgnore
  public void toJob(Job job) {
    job.setName(name);
    job.setDescription(description);
    job.setCite(cite);
    job.setCanMarry(canMarry);
    job.setLevel(level);
  }
}
