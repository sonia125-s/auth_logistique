package com.example.gestionutilisateur_service.mappsers;

import com.example.gestionutilisateur_service.dto.UserCredentialDTO;
import com.example.gestionutilisateur_service.entities.UserCredential;
import org.springframework.stereotype.Service;

@Service
public class UsersMapper {


    public UserCredentialDTO fromUserCredential(UserCredential userCredential){
        UserCredentialDTO user=new UserCredentialDTO();
        user.setId(userCredential.getId());
        user.setEmail(userCredential.getEmail());
        return user;

    }

    public UserCredential fromUser(UserCredentialDTO user){
        UserCredential userCredential=new UserCredential();
        userCredential.setId(user.getId());
        userCredential.setEmail(user.getEmail());
        return userCredential;

    }

}
