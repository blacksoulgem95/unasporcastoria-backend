package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "downtime_definitions")
@AllArgsConstructor
@RequiredArgsConstructor
public class DowntimeDefinition extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "note")
    private String note;

    @Column(name = "challenge")
    private Long challenge;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @OneToMany(mappedBy = "downtimeDefinition")
    private Set<Recipe> recipes = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "downtimeDefinitions")
    private Set<Item> items = new LinkedHashSet<>();


}
