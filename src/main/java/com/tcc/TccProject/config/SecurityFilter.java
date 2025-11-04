package com.tcc.TccProject.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private TokenConfig tokenConfig;

    public SecurityFilter(TokenConfig tokenConfig) {
        this.tokenConfig = tokenConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("🔒 Request path: " + request.getServletPath());
        System.out.println("🔒 Authorization header: " + request.getHeader("Authorization"));

        String path = request.getServletPath();
        if (path.startsWith("/auth/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorizedHeader = request.getHeader("Authorization");
        if (Strings.isNotEmpty(authorizedHeader) && authorizedHeader.startsWith("Bearer ")) {
            String token = authorizedHeader.substring("Bearer ".length());
            System.out.println("🔒 Token recebido: " + token);

            Optional<JWTUserData> optUser = tokenConfig.validateToken(token);
            System.out.println("🔒 Token válido: " + optUser.isPresent());

            List<SimpleGrantedAuthority> authorities = List.of(
                    new SimpleGrantedAuthority("ROLE_USER") // ou ROLE_ADMIN, conforme seu JWT
            );


            optUser.ifPresent(jwtUserData -> {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(jwtUserData, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                System.out.println("🔒 Autenticação configurada para usuário: " + jwtUserData.email());
            });
        } else {
            System.out.println("🔒 Nenhum header Authorization válido encontrado");
        }

        filterChain.doFilter(request, response);
    }}


