package com.example.gestionutilisateur_service.controllers;

import com.example.gestionutilisateur_service.dto.UserCredentialDTO;
import com.example.gestionutilisateur_service.dto.requests.AuthRequest;
import com.example.gestionutilisateur_service.entities.TokenToAngular;
import com.example.gestionutilisateur_service.entities.UserCredential;
import com.example.gestionutilisateur_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserCredential> addNewUser(@RequestBody UserCredentialDTO userCredentialDTO) {
        return new ResponseEntity<>(authService.saveUser(userCredentialDTO), HttpStatus.OK);
    }





    @PostMapping("/token")
    public TokenToAngular authenticate(@RequestBody AuthRequest authRequest) {
        String token = authService.authenticate(authRequest);
        TokenToAngular tokenToAngular=new TokenToAngular();
        tokenToAngular.setToken(token);
        return  tokenToAngular;
    }






/*

    @PostMapping("/token")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity<>(authService.authenticate(authRequest), HttpStatus.OK);
    }
*/

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
