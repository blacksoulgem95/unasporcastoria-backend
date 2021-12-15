package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "skill_groups")
@AllArgsConstructor
@RequiredArgsConstructor
public class SkillGroup {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "count")
    private Long count;

    @ManyToOne
    @Column(name = "job_id")
    private Job job;

    @ManyToMany(mappedBy = "skillGroups")
    private Set<Skill> skills = new java.util.LinkedHashSet<>();

}
