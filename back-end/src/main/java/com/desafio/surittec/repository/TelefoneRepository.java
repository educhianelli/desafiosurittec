package com.desafio.surittec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.surittec.entity.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {
}
