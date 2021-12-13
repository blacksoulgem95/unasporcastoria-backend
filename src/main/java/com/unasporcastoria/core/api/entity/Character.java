package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.CharacterType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "characters")
@AllArgsConstructor
@RequiredArgsConstructor
public class Character extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CharacterType type;

    @ManyToOne
    @JoinColumn(name = "faction_id")
    private Faction faction;

    @ManyToOne
    @JoinColumn(name = "faith_id")
    private Faith faith;

    @OneToMany(mappedBy = "owner")
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "characterSheet")
    private Set<CharacterAttribute> attributes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "characterSheet")
    private Set<CharacterBackground> backgrounds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "characterSheet")
    private Set<CharacterSkill> skills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "characterSheet")
    private Set<Downtime> downtimes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "character_discarded_skills",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> discardedSkills = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "character_faction_skills",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> factionSkills = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "character_job_skills",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> jobSkills = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "character_defects",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "defect_id"))
    private Set<Defect> defects = new LinkedHashSet<>();
}
