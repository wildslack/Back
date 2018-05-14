package fr.wildcodeschool.wildslackback.service;

import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.repo.RoleRepository;
import fr.wildcodeschool.wildslackback.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; // quand un utilisateur veux s'enregistrer je dois encoder son password avant envoie à la base
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName); // on va chercher le role en base
        AppUser user = userRepository.findByEmail(email);  // peux être changer par pseudo // on va cherche l'utilisateur en base
        user.getRoles().add(role); //j'ajoute le role à l'utilisateur
        // la méthode est transctionnel donc quand elle commit elle sait qu'on ajouté un role et donc le rajoute au niveau de la base
        // dans la table d'association
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
