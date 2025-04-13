package com.joao.marques.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(@NonNull CorsRegistry registry) {
		// Permite todas as origens para a URL /manga
		registry.addMapping("/manga")
				.allowedOrigins("http://localhost:3000") // Substitua pelo seu domínio do frontend
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("*");
	}
}
