package com.turmaa.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.turmaa.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
