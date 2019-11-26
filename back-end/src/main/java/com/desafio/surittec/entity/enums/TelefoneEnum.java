package com.desafio.surittec.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TelefoneEnum {
	RESIDENCIAL("RESIDENCIAL", "Residencial"), COMERCIAL("COMERCIAL", "Comercial"), CELULAR("CELULAR", "Celular");

	private String nome;
	private String sigla;

	private TelefoneEnum(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public static Optional<TelefoneEnum> findBySigla(String sigla) {
		return Arrays.asList(TelefoneEnum.values()).stream().filter(tel -> tel.getSigla().equalsIgnoreCase(sigla))
				.findFirst();

	}

	public static String getSiglaByNome(String nome) {
		return Arrays.asList(TelefoneEnum.values()).stream().filter(tel -> tel.getNome().equalsIgnoreCase(nome))
				.findFirst().get().getSigla();
	}
}
