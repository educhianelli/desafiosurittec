package com.desafio.surittec.entity.enums;

public enum SegurancaEnum {
	SECRET("Secret"),
	TOKEN_PREFIXO("Bearer "),
	HEADER_STRING("Authorization"),
	SIGN_UP("/users/sign-up"),
	EXPIRATION_TOKE("86400000");
	
	private String nome;

	private SegurancaEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
