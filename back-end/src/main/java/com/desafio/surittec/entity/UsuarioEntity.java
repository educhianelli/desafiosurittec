package com.desafio.surittec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.desafio.surittec.convert.TelefoneConvert;
import com.desafio.surittec.entity.enums.UsuarioEnum;

@Entity
@Table(name="USUARIO")
public class UsuarioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty
	@Column(name="username",length=50)
	private String userName;
	@Column(name="senha",length=100)
	@NotEmpty
	private String senha;
	@Convert(converter=TelefoneConvert.class)
	@Column(name = "tipo")
	private UsuarioEnum tipoUsuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(UsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	

}
