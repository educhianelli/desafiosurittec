package com.desafio.surittec;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.entity.EmailEntity;
import com.desafio.surittec.entity.EnderecoEntity;
import com.desafio.surittec.entity.TelefoneEntity;
import com.desafio.surittec.entity.enums.TelefoneEnum;
import com.desafio.surittec.service.ClienteService;


@SpringBootApplication
public class SurittecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurittecApplication.class, args);
		
	}
	
	@Bean
    CommandLineRunner initDatabase(ClienteService service) {
        return args -> {
            service.cadastraCliente(criaCliente());
            
        };
    }
	
	
	

	public ClienteEntity criaCliente() {
		EnderecoEntity en = new EnderecoEntity();
		en.setBairro("Tagua");
		en.setCep("72002405");
		en.setComplemento("Rua 1");
		en.setEstado("Distrito Federal");
		en.setLogradouro("CAS");
		en.setUf("DF");
		
		TelefoneEntity tel = new TelefoneEntity();
		tel.setNumero("998610061");
		tel.setTipoTelefoneEnum(TelefoneEnum.CELULAR);
		
		ClienteEntity cl = new ClienteEntity();
		cl.setCpf("05066861165");
		cl.setNome("Cachorros do mangue");
		cl.setEndereco(en);
		cl.setTelefones(Arrays.asList(tel));
		
		cl.setEmails(Arrays.asList(new EmailEntity("educhianelli@gmail.com")));
		
		return cl;
	}
}
