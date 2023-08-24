package com.example.gestionutilisateur_service.service.implementation;

import com.example.gestionutilisateur_service.dto.UserCredentialDTO;
import com.example.gestionutilisateur_service.dto.UserLogin;
import com.example.gestionutilisateur_service.entities.AppRole;
import com.example.gestionutilisateur_service.entities.UserCredential;
import com.example.gestionutilisateur_service.enums.Role;
import com.example.gestionutilisateur_service.mappsers.UsersMapper;
import com.example.gestionutilisateur_service.repository.UserRepository;
import com.example.gestionutilisateur_service.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<UserCredentialDTO> getTransporteurs(Role role) {
        List<UserCredential> list = userRepository.findAll();
        List<UserCredentialDTO> listuser=new ArrayList<>();
        UserCredentialDTO userCredentialDTO=new UserCredentialDTO();
        for(UserCredential u:list){
            userCredentialDTO.setId(u.getId());
            userCredentialDTO.setUsername(u.getUsername());
            userCredentialDTO.setPassword(u.getPassword());
            userCredentialDTO.setEmail(u.getEmail());
            Set<AppRole> roles=u.getRoles();
            userCredentialDTO.setRole(roles.iterator().next().getName());
            listuser.add(userCredentialDTO);
        }
   return listuser;
    }

    @Override
    public UserCredentialDTO getUser(Long id) {
        UserCredential userCredential = userRepository.findById(id).orElse(null);
        return usersMapper.fromUserCredential(userCredential);

    }

    @Override
    public UserCredential addUser(UserCredential userCredential) {
        System.out.println("ajout*********");
        System.out.println(userCredential.getEmail());
        return userRepository.save(userCredential);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserCredential updateUser(UserCredential userCredential) {
        return userRepository.save(userCredential);
    }

    @Override
    public List<UserCredential> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserCredential login(UserLogin userLogin) {
        Optional<UserCredential> userCredential = userRepository.findByUsername(userLogin.getUsername());
        if (userCredential.isPresent()) {
            throw new RuntimeException("Nom d'utilisateur n'existe pas");
        } else {
            if (userCredential.get().getPassword().equals(userLogin.getPassword())) {
                return userCredential.get();
            } else {
                throw new RuntimeException("Mot de passe incorrect");
            }
        }
    }

    @Override
    public UserCredential loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserCredential> getAllUser(){
        return userRepository.findAll();
    }
}
