package org.sopt.ticketbay.global.config.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    private static final List<String> ALLOWED_ORIGINS = List.of(
        "http://localhost:5173",
        "https://37-collaboration-web-ticketbay.vercel.app"
    );

    private static final List<String> ALLOWED_METHODS = List.of(
        "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"
    );

    private static final List<String> ALLOWED_HEADERS = List.of(
        "Authorization", "Content-Type"
    );

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(ALLOWED_ORIGINS);
        config.setAllowedMethods(ALLOWED_METHODS);
        config.setAllowedHeaders(ALLOWED_HEADERS);
        config.setAllowCredentials(false);
        config.setMaxAge(3_600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
