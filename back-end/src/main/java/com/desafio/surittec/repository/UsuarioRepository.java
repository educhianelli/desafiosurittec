package com.desafio.surittec.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.desafio.surittec.entity.UsuarioEntity;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {
	UsuarioEntity findByUserName(String userName);
}
