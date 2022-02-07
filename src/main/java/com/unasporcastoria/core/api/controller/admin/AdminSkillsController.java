package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.SkillCreateDto;
import com.unasporcastoria.core.api.dto.SkillUpdateDto;
import com.unasporcastoria.core.api.entity.Skill;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/skills")
@RequiredArgsConstructor
public class AdminSkillsController {

  private final SkillService skillService;

  @GetMapping
  public Page<Skill> getSkills(@RequestParam(value = "name", required = false) String name,
                               Pageable pageable) {
    return skillService.findAll(pageable, name);
  }

  @GetMapping("/{id}")
  public Skill getSkill(@PathVariable("id") Long id) {
    return skillService.get(id).orElseThrow(() -> new NotFoundException("Skill"));
  }

  @PostMapping
  public Skill createSkill(@RequestBody SkillCreateDto skill) {
    return skillService.createSkill(skill);
  }

  @DeleteMapping("/{id}")
  public void deleteSkill(@PathVariable("id") Long id) {
    skillService.delete(id);
  }

  @PutMapping("/{id}")
  public Skill updateSkill(@PathVariable("id") Long id, @RequestBody SkillUpdateDto skill) {
    return skillService.update(id, skill);
  }

}
