package com.domain.ecommerce.controllers;

import com.domain.ecommerce.models.AuthenticationDTO;
import com.domain.ecommerce.models.Client;
import com.domain.ecommerce.models.LoginResponseDTO;
import com.domain.ecommerce.models.RegisterDTO;
import com.domain.ecommerce.repositories.ClientRepository;
import com.domain.ecommerce.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final ClientRepository clientRepository;
    private final TokenService tokenService;

    AuthenticationController(AuthenticationManager authenticationManager, ClientRepository clientRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.clientRepository = clientRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(),
                authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((Client) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if(this.clientRepository.findByEmail(registerDTO.email()).isPresent()) return ResponseEntity.badRequest().build();

        String encryptedLogin = new BCryptPasswordEncoder().encode(registerDTO.password());
        Client newClient = new Client(registerDTO.email(), encryptedLogin, registerDTO.role());
        this.clientRepository.save(newClient);
        return ResponseEntity.ok().build();
    }
}
