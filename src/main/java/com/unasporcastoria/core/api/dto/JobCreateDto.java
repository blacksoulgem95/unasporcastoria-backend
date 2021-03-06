package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Job;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobCreateDto implements Serializable {
  protected String name;
  protected String cite;
  protected String description;
  protected Boolean canMarry = true;
  protected Long level;

  @JsonIgnore
  public Job toJob() {
    var job = new Job();
    job.setName(name);
    job.setDescription(description);
    job.setCite(cite);
    job.setCanMarry(canMarry);
    job.setLevel(level);
    return job;
  }
}
