package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_types")
@AllArgsConstructor
@RequiredArgsConstructor
public class JobType {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "label")
  private String label;

  @Column(name = "requisite")
  private Long requisite;

  @ManyToOne
  @JoinColumn(name = "job_id")
  private Job job;

}
