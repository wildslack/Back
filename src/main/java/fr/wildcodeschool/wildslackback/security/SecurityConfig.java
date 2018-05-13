package fr.wildcodeschool.wildslackback.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

        /* snippet pour tester l'authentification sans passer par la base
        auth.inMemoryAuthentication()
                .withUser("steph").password("1234").roles("ADMIN", "USER")
                .and() // patern builder, on peux sinon mettre un ';'  pour ajouter un autre user de test pendant le dev
                .withUser("julien").password("1234").roles("USER");
                */
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // desactive la génération automatique du jeton csrf de spring, attention ceci ouvre une breche de securité cross site request forgery
                                            // (verifier dans le header de la reponse http que dans set-cookie il y a bien la notion "HttpOnly qui interdit de lire le javascript).
        http.formLogin();
        http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/private/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();  //(Config pour obliger un user à se connecter, avec cette congi toute les ressources son ainsi sécurisées)

    }


}
