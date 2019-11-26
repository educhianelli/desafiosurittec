package com.desafio.surittec.convert;

import java.util.Optional;

import javax.persistence.AttributeConverter;

import com.desafio.surittec.entity.enums.UsuarioEnum;

public class UsuarioConvert implements AttributeConverter<UsuarioEnum, String> {

	@Override
	public String convertToDatabaseColumn(UsuarioEnum user) {
		// TODO Auto-generated method stub
		return user.getSigla();
	}

	@Override
	public UsuarioEnum convertToEntityAttribute(String sigla) {
		// TODO Auto-generated method stub
		Optional<UsuarioEnum> temp = UsuarioEnum.findBySigla(sigla);
		return temp.orElseThrow(IllegalArgumentException::new);
	}

}
