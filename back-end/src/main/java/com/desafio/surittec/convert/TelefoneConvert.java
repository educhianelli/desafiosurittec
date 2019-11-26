package com.desafio.surittec.convert;

import java.util.Optional;

import javax.persistence.AttributeConverter;

import com.desafio.surittec.entity.enums.TelefoneEnum;

public class TelefoneConvert implements AttributeConverter<TelefoneEnum, String> {

	@Override
	public String convertToDatabaseColumn(TelefoneEnum telefone) {
		// TODO Auto-generated method stub
		return telefone.getSigla();
	}

	@Override
	public TelefoneEnum convertToEntityAttribute(String sigla) {
		// TODO Auto-generated method stub
		Optional<TelefoneEnum> temp = TelefoneEnum.findBySigla(sigla);
		return temp.orElseThrow(IllegalArgumentException::new);
	}

}
