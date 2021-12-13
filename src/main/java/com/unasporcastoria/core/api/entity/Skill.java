package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "skills")
@AllArgsConstructor
@RequiredArgsConstructor
public class Skill extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description_1")
    private String description1;

    @Lob
    @Column(name = "description_2")
    private String description2;

    @OneToMany(mappedBy = "skill")
    private Set<Dot> skillDots = new LinkedHashSet<>();

    @OneToMany(mappedBy = "skill")
    private Set<DowntimeDefinition> downtimeDefinitions = new LinkedHashSet<>();

}

