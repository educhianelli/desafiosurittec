package com.desafio.surittec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.desafio.surittec.entity.UsuarioEntity;
import com.desafio.surittec.entity.enums.UsuarioEnum;
import com.desafio.surittec.repository.UsuarioRepository;

@Service
public class CustomUserDetailService{// implements UserDetailsService {

/*	private final UsuarioRepository repository;

	@Autowired
	public CustomUserDetailService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UsuarioEntity u = Optional.ofNullable(repository.findByUserName(userName))
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

		return new User(u.getUserName(), 
				        u.getSenha(),
				        u.getTipoUsuario().getSigla().equals(UsuarioEnum.ADMINISTRADOR.getSigla()) ? authorityListAdmin : authorityListUser );
	}
*/
}
