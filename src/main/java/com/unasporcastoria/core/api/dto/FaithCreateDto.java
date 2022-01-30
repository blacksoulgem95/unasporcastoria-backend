package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.entity.Job;
import lombok.Data;

import java.io.Serializable;

@Data
public class FaithCreateDto implements Serializable {
  private String name;
  private String description;
  private Long limitSpouses = 1L;

  @JsonIgnore
  public Faith toFaith() {
    var faith = new Faith();
    faith.setName(name);
    faith.setDescription(description);
    faith.setLimitSpouses(limitSpouses);
    return faith;
  }
}
