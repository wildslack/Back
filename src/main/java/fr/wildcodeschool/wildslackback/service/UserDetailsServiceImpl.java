package fr.wildcodeschool.wildslackback.service;

import fr.wildcodeschool.wildslackback.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service // couche de service pour la gestion des utilisateurs
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser u = accountService.findUserByEmail(email); // je sais pas si  sa passe avec cette methode sinon changer pour pseudo
        if (u == null) throw new UsernameNotFoundException(email);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        u.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        return new User(u.getEmail(), u.getPassword(), authorities);
    }
}
