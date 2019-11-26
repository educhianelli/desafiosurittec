package com.desafio.surittec.repository.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ClienteEntity> filtrar(ClienteFilter clienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ClienteEntity> criteria = builder.createQuery(ClienteEntity.class);

		Root<ClienteEntity> root = criteria.from(ClienteEntity.class);

		Predicate[] predicates = restricoesCriteria(clienteFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ClienteEntity> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] restricoesCriteria(ClienteFilter clienteFilter, CriteriaBuilder builder,
			Root<ClienteEntity> root) {
		List<Predicate> predicates = new ArrayList<>();

		if(!StringUtils.isEmpty(clienteFilter.getNome())) { //Configurar o MetaModel (jpamodelgen)
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + clienteFilter.getNome().toLowerCase() + "%")); //where nome like %joselito%
			
		}
		if(!StringUtils.isEmpty(clienteFilter.getCpf())) {
			predicates.add(builder.like(builder.lower(root.get("cpf")), "%" + clienteFilter.getCpf() + "%")); //where nome like %050%
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
