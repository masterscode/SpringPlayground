package spring.springdemo.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class SecurityAuthorisationConstants {
    private static final byte[] KEY = "THE_ULTIMATE_SECRET".getBytes(StandardCharsets.UTF_8);
    public static final String SECRET = Base64.getEncoder().encodeToString(KEY);
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String[] PUBLIC_URIS = new String[]{
                    "/**",
                    "/others",
                    "/v2/api-docs",
                    "/swagger-resources",
                    "/swagger-resources/**",
                    "/configuration/ui",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**",
                    // -- Swagger UI v3 (OpenAPI)
                    "/v3/api-docs/**",
                    "/swagger-ui/**"};
}