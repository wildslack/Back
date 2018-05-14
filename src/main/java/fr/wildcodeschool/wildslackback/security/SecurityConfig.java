package fr.wildcodeschool.wildslackback.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;  //instanciation d'un bean spring dans la classe main

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // desactive la génération automatique du jeton csrf de spring, attention ceci ouvre une breche de securité cross site request forgery
                                            // (verifier dans le header de la reponse http que dans set-cookie il y a bien la notion "HttpOnly qui interdit de lire le javascript).
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.formLogin(); // je desactive la session et rend le systeme "stateless"
        http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/messages/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();  //(Config pour obliger un user à se connecter, avec cette congi toute les ressources son ainsi sécurisées)
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));

    }


}
