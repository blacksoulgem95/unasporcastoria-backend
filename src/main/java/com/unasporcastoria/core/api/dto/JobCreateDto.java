package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Job;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobCreateDto implements Serializable {
  private String name;
  private String cite;
  private String description;
  private Boolean canMarry = true;

  @JsonIgnore
  public Job toJob() {
    var job = new Job();
    job.setName(name);
    job.setDescription(description);
    job.setCite(cite);
    job.setCanMarry(canMarry);
    return job;
  }
}
