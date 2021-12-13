package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "faiths")
@AllArgsConstructor
@RequiredArgsConstructor
public class Faith extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "limit_wife")
    private Long limitWife = 1L;

    @OneToMany
    private Set<Character> characters = new LinkedHashSet<>();
}
