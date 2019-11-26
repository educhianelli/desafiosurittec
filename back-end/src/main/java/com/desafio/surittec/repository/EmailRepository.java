package com.desafio.surittec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.surittec.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

}
