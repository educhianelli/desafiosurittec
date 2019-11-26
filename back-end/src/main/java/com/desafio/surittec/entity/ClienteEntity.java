package com.desafio.surittec.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="CLIENTE")
public class ClienteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@NotEmpty
	@Size(min=3, max=100)
    //@Pattern(regexp = "[a-zA-Z]", message = "Não é permitido caracter especial!")
	@Column(name="nome",length = 100, nullable = false)
	private String nome;
	@NotEmpty
	@CPF(message="CPF inválido!")
	@Column(name="cpf",length = 11, nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,  cascade= CascadeType.ALL)
	 //@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<TelefoneEntity> telefones;
	
	@OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private EnderecoEntity endereco;
	

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,  cascade= CascadeType.ALL)
	private List<EmailEntity> emails;
	
	
	
	/*@ElementCollection()
	@CollectionTable(name="cliente_email",
					 joinColumns = @JoinColumn(name="cliente_id"))
	@Column(name="email")
	@OrderColumn
	private List<String> emails;*/
	
	public ClienteEntity() {
	}
	
	public ClienteEntity(@NotEmpty @Size(min = 3, max = 100) @Pattern(regexp = "[0-9a-zA-Z\\s]", message = "Não é permitido caracter especial!") String nome,
			@NotEmpty @CPF(message = "CPF inválido!") String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	


	public ClienteEntity(
			@NotEmpty @Size(min = 3, max = 100) @Pattern(regexp = "[0-9a-zA-Z\\s]", message = "Não é permitido caracter especial!") String nome,
			@NotEmpty @CPF(message = "CPF inválido!") String cpf, List<TelefoneEntity> telefones,
			EnderecoEntity endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.endereco = endereco;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<TelefoneEntity> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneEntity> telefones) {
		this.telefones = telefones;
	}
	public EnderecoEntity getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public List<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailEntity> emails) {
		this.emails = emails;
	}

	




	
	
}




