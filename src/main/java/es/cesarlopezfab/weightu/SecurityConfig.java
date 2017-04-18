package es.cesarlopezfab.weightu;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
        //FIXME: read from properties
                .forRS256("https://weight-u.herokuapp.com/", "https://cesarlopezfa.eu.auth0.com/")
                .configure(http)
                .authorizeRequests()
                .regexMatchers("/").permitAll()
                .regexMatchers("/dist/build.js").permitAll()
                .antMatchers("/api/weights/**").authenticated()
                .anyRequest().authenticated();
    }
}