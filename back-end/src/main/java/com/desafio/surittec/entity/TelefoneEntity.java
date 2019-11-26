package com.desafio.surittec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.desafio.surittec.convert.TelefoneConvert;
import com.desafio.surittec.entity.enums.TelefoneEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TELEFONE")
public class TelefoneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Convert(converter = TelefoneConvert.class)
	@Column(name = "tipo")
	private TelefoneEnum tipoTelefone;
	
//	@Transient
	//private String tipoTelefoneFrontEnd;

	@Column(name = "numero", length = 12)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
    @JsonIgnore
	private ClienteEntity cliente;
	
	

	
	public TelefoneEntity() {
		super();
	}

	public TelefoneEntity(TelefoneEnum tipoTelefoneEnum, String numero) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.numero = numero;
	}

	
	public TelefoneEnum getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TelefoneEnum tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public TelefoneEnum getTipoTelefoneEnum() {
		return tipoTelefone;
	}

	public void setTipoTelefoneEnum(TelefoneEnum tipoTelefoneEnum) {
		this.tipoTelefone = tipoTelefoneEnum;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

}
