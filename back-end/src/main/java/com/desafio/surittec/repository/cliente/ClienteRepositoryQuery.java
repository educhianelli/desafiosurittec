package com.desafio.surittec.repository.cliente;

import java.util.List;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {

	public List<ClienteEntity>filtrar(ClienteFilter clienteFilter);
}
