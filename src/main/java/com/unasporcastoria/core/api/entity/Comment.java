package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment extends BaseEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "author", nullable = false)
  private String author;

  @Lob
  @Column(name = "text")
  private String text;

  @ManyToOne
  @JoinColumn(name = "downtime_id")
  private Downtime downtime;
}
