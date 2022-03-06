package com.essentialrage.samples.springbootkafka.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests(auth -> auth.antMatchers("/actuator/health/**").permitAll()
                        .antMatchers("/actuator/info").permitAll()
                        .antMatchers("/actuator/metrics/**").permitAll()
                        .antMatchers("/actuator/jolokia/**").permitAll()
                        .antMatchers("/actuator/prometheus/**").permitAll()
                        .antMatchers("/sample-resource/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
