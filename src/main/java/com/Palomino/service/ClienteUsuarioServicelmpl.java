package com.Palomino.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Palomino.dto.ClienteUsuarioDTORequest;
import com.Palomino.dto.ClienteUsuarioDTOResponse;
import com.Palomino.model.UsuarioCliente;
import com.Palomino.repository.ClienteUsuarioRepository;

@Service
public class ClienteUsuarioServicelmpl implements ClienteUsuarioService{

	
	@Autowired
	private ClienteUsuarioRepository repository;
	
	@Override
	public void guardarClienteUsuario(ClienteUsuarioDTORequest clienteUsuario) {
		
		UsuarioCliente p = new UsuarioCliente();
		p.setUsuario(clienteUsuario.getUsuario());
		p.setPassword(p.getPassword());
		p.setRol(clienteUsuario.getRol());
		repository.save(p);
	}
		

	@Override
	public void actualizarClienteUsuario(ClienteUsuarioDTORequest clienteUsuario) {
		UsuarioCliente p = new UsuarioCliente();
		p.setUsuario(clienteUsuario.getUsuario());
		p.setPassword(p.getPassword());
		p.setRol(clienteUsuario.getRol());
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarClienteUsuario(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<ClienteUsuarioDTOResponse> listarClienteUsuario() {
		List<ClienteUsuarioDTOResponse> listar = new ArrayList<>();
		
		ClienteUsuarioDTOResponse dto = null;
		
		List<UsuarioCliente> p = repository.findAll();
		
		for (UsuarioCliente usuairoCliente : p) {
			
			dto = new ClienteUsuarioDTOResponse();
			
			dto.setUsuario(usuairoCliente.getUsuario());
			dto.setPassword(usuairoCliente.getPassword());
			dto.setRol(usuairoCliente.getRol());
		
			
			listar.add(dto);
		}
		
		return listar;
	
	}

	@Override
	public ClienteUsuarioDTOResponse obtenerClienteUsuarioId(Integer id) {
		UsuarioCliente usuairoCliente = repository.findById(id).orElse(null);
		ClienteUsuarioDTOResponse dto = new ClienteUsuarioDTOResponse();
		
		dto.setUsuario(usuairoCliente.getUsuario());
		dto.setPassword(usuairoCliente.getPassword());
		dto.setRol(usuairoCliente.getRol());
	
		
		return dto;
	}

}
