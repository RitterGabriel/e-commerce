package com.domain.ecommerce.repositories;

import com.domain.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<UserDetails> findByEmail(String email);
}
