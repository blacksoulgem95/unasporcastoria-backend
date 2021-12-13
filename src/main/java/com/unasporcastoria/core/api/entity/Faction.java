package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.FactionType;
import com.unasporcastoria.core.api.enums.FactionVisibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "factions")
@AllArgsConstructor
@RequiredArgsConstructor
public class Faction extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FactionType type;

    @Column(name = "visibility", nullable = false)
    @Enumerated(EnumType.STRING)
    private FactionVisibility visibility;

    @OneToMany(mappedBy = "faction")
    private Set<Character> characters = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "faction_skills",
            joinColumns = @JoinColumn(name = "faction_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new LinkedHashSet<>();
}
