package com.dev.Backend.repository;

import com.dev.Backend.model.imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<imagem, Long> {
}
