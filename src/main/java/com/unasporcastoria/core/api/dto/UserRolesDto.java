package com.unasporcastoria.core.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserRolesDto {
  private Set<String> roles;
}
