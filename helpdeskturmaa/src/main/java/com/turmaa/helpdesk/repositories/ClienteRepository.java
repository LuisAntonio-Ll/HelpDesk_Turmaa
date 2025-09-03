package com.turmaa.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.turmaa.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByEmail(String email);
}
