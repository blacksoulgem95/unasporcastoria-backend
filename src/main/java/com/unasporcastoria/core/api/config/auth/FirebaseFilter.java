package com.unasporcastoria.core.api.config.auth;

import com.unasporcastoria.core.api.exception.FirebaseTokenInvalidException;
import com.unasporcastoria.core.api.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class FirebaseFilter extends OncePerRequestFilter {

  private static final String HEADER_NAME = "X-Authorization-Firebase";

  private final FirebaseService firebaseService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String xAuth = request.getHeader(HEADER_NAME);

    if (!StringUtils.isBlank(xAuth)) {
      try {
        log.debug("Starting Firebase Authentication");
        FirebaseTokenHolder holder = firebaseService.parseToken(xAuth);

        String userName = holder.getUid();
        log.debug("Got user ID");

        Authentication auth = new FirebaseAuthenticationToken(userName, holder);
        SecurityContextHolder.getContext().setAuthentication(auth);
        log.debug( "Authentication Context set");

        filterChain.doFilter(request, response);
      } catch (FirebaseTokenInvalidException e) {
        log.debug("Cannot authenticate", e);
        throw new SecurityException(e);
      }
    } else {
      filterChain.doFilter(request, response);
    }
  }

}