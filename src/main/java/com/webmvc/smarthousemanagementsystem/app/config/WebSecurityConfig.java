package com.webmvc.smarthousemanagementsystem.app.config;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/static/**/*", "/auth/**/*", "/api/**/*").permitAll()
                .anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/home", true)
                .loginPage("/login").permitAll().and().logout().permitAll();
    }

    @SuppressWarnings({"deprecation"})
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub
                return Arrays.asList(new SimpleGrantedAuthority("USER"));
            }

            @Override
            public String getPassword() {
                return "u";
            }

            @Override
            public String getUsername() {
                return "u@mail.ru";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return Boolean.TRUE;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return Boolean.TRUE;
            }

            @Override
            public boolean isEnabled() {
                return Boolean.TRUE;
            }
        });
    }


}
