
  package com.demo.spring.Application.config;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.security.authentication.AuthenticationManager; import
  org.springframework.security.config.BeanIds; import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.authentication.configuration.
  AuthenticationConfiguration; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import
  org.springframework.security.config.annotation.web.builders.WebSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter; import
  org.springframework.security.config.http.SessionCreationPolicy; import
  org.springframework.security.crypto.password.NoOpPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder; import
  org.springframework.security.web.SecurityFilterChain; import
  org.springframework.security.web.authentication.
  UsernamePasswordAuthenticationFilter; import
  org.springframework.web.servlet.config.annotation.CorsRegistry; import
  org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
  import com.demo.spring.Application.filter.JwtFilter; import
  com.demo.spring.Application.service.CustomUserDetailsService;
  
  @Configuration
  
  @EnableWebSecurity public class SecurityConfig {
  
  @Autowired private CustomUserDetailsService userDetailsService;
  
  @Autowired private JwtFilter jwtFilter;
  
  @Bean
  public PasswordEncoder passwordEncoder(){
      return NoOpPasswordEncoder.getInstance();
  }
  @Bean public AuthenticationManager
  authenticationManager(AuthenticationConfiguration
  authenticationConfiguration) throws Exception { return
  authenticationConfiguration.getAuthenticationManager(); }
  
  @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
  Exception {
  
  
  AuthenticationManagerBuilder authenticationManagerBuilder =
  http.getSharedObject(AuthenticationManagerBuilder.class);
  authenticationManagerBuilder.userDetailsService(userDetailsService);
  AuthenticationManager authenticationManager =
  authenticationManagerBuilder.build();
  
  http.csrf().disable().cors().disable() .authorizeHttpRequests()
  .antMatchers("/authenticate", "/api/v2/registrations/**").permitAll()
  .anyRequest().authenticated() .and()
  .authenticationManager(authenticationManager)
  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  
  return http.build(); }
  
  
  public void configure(WebSecurity web) throws Exception { web.ignoring()
  .antMatchers("/api/v2/registrations/"); } }
