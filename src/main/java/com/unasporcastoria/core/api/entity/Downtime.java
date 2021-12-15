package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "downtimes")
@AllArgsConstructor
@RequiredArgsConstructor
public class Downtime extends BaseEntity {

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
    @Column(name = "resolution")
    private String resolution;

    @Column(name = "resolution_time")
    private LocalDateTime resolutionTime;

    @Column(name = "story_teller")
    private String storyTeller;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character characterSheet;

    @OneToMany(mappedBy = "downtime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "downtime", cascade = CascadeType.DETACH)
    private Set<InventoryEntry> entries = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
