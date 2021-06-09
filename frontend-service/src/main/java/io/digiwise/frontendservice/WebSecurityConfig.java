package io.digiwise.frontendservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/list", "/fixtures", "/viewPlayer/{id}", "/style/style.css", "/images/cubs.png", "/images/boy.png", "/images/girl.png", "/images/calendar.png", "/", "/listest", "/player", "/tutor", "/images/abs.png",  "/images/add.png",  "/images/bulletin.png",  "/images/coach-abs.jpg",  "/images/fixtures.png",  "/images/football.png",  "/images/player.png",  "/images/player-abs.png",  "/images/red.png",  "/images/result.png", "/images/result_game.png", "/images/test.png", "/images/yellow.png").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin@cubs.com")
                        .password("cubs@123")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}