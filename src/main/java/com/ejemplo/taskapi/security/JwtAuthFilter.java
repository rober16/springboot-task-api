package com.ejemplo.taskapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        // Verifica si existe el header Authorization
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extrae el token eliminando "Bearer "
        String token = authHeader.substring(7);

        // Obtiene username desde el JWT
        String username = jwtService.extractUsername(token);

        // Verifica que el usuario exista y no haya autenticación previa
        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            // Carga usuario desde base de datos
            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            // Valida token
            if (jwtService.isTokenValid(token, username)) {

                // Crea objeto de autenticación
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                // Agrega detalles de la request
                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                // Guarda autenticación en el contexto de Spring Security
                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}