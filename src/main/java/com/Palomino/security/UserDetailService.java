package com.Palomino.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Palomino.model.UsuarioCliente;
import com.Palomino.repository.ClienteUsuarioRepository;



@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private ClienteUsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioCliente usuarioCliente = repository.findByUsuario(username);
		
		if(usuarioCliente != null){
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority(usuarioCliente.getRol());
			
			listGranted.add(granted);
			
			return new User(usuarioCliente.getUsuario(),usuarioCliente.getPassword() , listGranted);
			
		}else
			throw new UsernameNotFoundException("Usuario no existe " + username);
	}

}
