package com.example.edelec.security.config;

import com.example.edelec.security.config.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService Service;

    private final BCryptPasswordEncoder cr;

    public SecurityConfig(@Lazy BCryptPasswordEncoder cr, UserService Service) {
        this.cr = cr;
        this.Service = Service;
    }

  @Bean
   public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }
@Override
    protected void configure(AuthenticationManagerBuilder auth)
     throws Exception {
         auth.userDetailsService(Service).passwordEncoder(cr);




}
    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
      http
              .cors();
      http
              .csrf().disable();
      http
              .authorizeRequests().antMatchers("/comments/").fullyAuthenticated();
      http.authorizeRequests().antMatchers("/usuarios/register").permitAll();
        http
                .authorizeRequests().antMatchers("/usuarios/login").fullyAuthenticated().and()
                .httpBasic();

    }



}
