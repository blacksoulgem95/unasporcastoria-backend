package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "backgrounds")
@AllArgsConstructor
@RequiredArgsConstructor
public class Background extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "bonus")
    private String bonus;

    @Column(name = "malus")
    private String malus;

    @Column(name = "keep")
    private String keep;

    @Column(name = "extra")
    private String extra;

    @Lob
    @Column(name = "note")
    private String note;

    @Column(name = "count")
    private Long count;

    @Column(name = "cost_type")
    private Long costType;

    @OneToMany(mappedBy = "background")
    private Set<Dot> backgroundDots = new LinkedHashSet<>();
}
