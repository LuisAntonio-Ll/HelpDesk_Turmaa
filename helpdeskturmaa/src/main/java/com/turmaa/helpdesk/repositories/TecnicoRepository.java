package com.turmaa.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.turmaa.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	Optional<Tecnico> findByCpf(String cpf);

    Optional<Tecnico> findByEmail(String email);
}
