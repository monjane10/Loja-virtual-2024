package com.dev.Backend.repository;

import com.dev.Backend.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaClientRepository extends JpaRepository<Pessoa, Long> {

}
