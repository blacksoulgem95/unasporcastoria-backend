package com.unasporcastoria.core.api.service;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.unasporcastoria.core.api.config.SecurityConfig;
import com.unasporcastoria.core.api.dto.UserDto;
import com.unasporcastoria.core.api.dto.UserRolesDto;
import com.unasporcastoria.core.api.exception.FirebaseTokenInvalidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service(value = UserService.NAME)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService {

  public final static String NAME = "UserService";
  private final FirebaseAuth firebaseAuth;
  private final Firestore firestore;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      UserRecord user = firebaseAuth.getUser(username);
      var collection = firestore.collection(SecurityConfig.Roles.COLLECTION);

      if (user == null)
        return null;

      Set<String> roles = new HashSet<>();
      DocumentSnapshot snap = collection.document(user.getUid()).get().get();
      if (!snap.exists()) {
        collection.document(user.getUid()).create(Map.of("roles", List.of(SecurityConfig.Roles.ROLE_USER)));
        roles.add(SecurityConfig.Roles.ROLE_USER);
      } else {
        var userRoles = snap.toObject(UserRolesDto.class);
        roles.addAll(Optional.ofNullable(Objects.requireNonNull(userRoles).getRoles())
            .orElse(new LinkedList<>(List.of(SecurityConfig.Roles.ROLE_USER))));
      }

      log.debug("loadUserByUsername - User {} - loaded authorities ({})", username, roles);

      UserDetails userDetails = UserDto.generate(user,
          roles.stream().map(SimpleGrantedAuthority::new)
              .collect(Collectors.toSet()));

      return new org.springframework.security.core.userdetails.User(userDetails.getUsername(),
          userDetails.getPassword(), userDetails.getAuthorities());
    } catch (Exception e) {
      log.debug("Error in loadUserByUsername", e);
      throw new FirebaseTokenInvalidException(e.getMessage(), e);
    }
  }

}
