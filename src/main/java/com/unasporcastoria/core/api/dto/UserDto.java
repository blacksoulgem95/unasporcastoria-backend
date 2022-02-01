package com.unasporcastoria.core.api.dto;

import com.google.firebase.auth.UserRecord;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Data
@Builder()
public class UserDto implements UserDetails {

  String uid;
  String username;
  String displayName;
  String profilePic;
  String password;
  boolean credentialsNonExpired;
  boolean accountNonExpired;
  boolean accountNonLocked;
  boolean enabled;
  Set<? extends GrantedAuthority> authorities;

  public static UserDto generate(UserRecord record, Set<? extends GrantedAuthority> authorities) {
    return UserDto.builder()
        .uid(record.getUid())
        .username(record.getEmail())
        .displayName(record.getDisplayName())
        .profilePic(record.getPhotoUrl())
        .password("NOPASS")
        .authorities(authorities)
        .enabled(true)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .authorities(authorities)
        .build();
  }
}
