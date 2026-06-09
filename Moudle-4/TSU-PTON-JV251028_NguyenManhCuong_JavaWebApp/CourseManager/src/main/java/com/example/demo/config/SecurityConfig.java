package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer{
	@Value("${upload.path}") 
    private String uploadPath;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {        // Lưu ý: Nếu uploadPath là C:/uploads/ thì phải thêm dấu "/" ở cuối hoặc ở locations
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath);
    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/", "/courses", "/images/**", "/uploads/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	            .defaultSuccessUrl("/", true)   
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .logoutSuccessUrl("/")
	            .permitAll()
	        )
	        .csrf(csrf -> csrf.disable());
	
	    return http.build();
	}


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}123456") 
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(admin);
    }
}