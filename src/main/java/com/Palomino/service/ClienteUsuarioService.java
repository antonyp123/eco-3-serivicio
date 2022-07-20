package com.Palomino.service;

import java.util.List;

import com.Palomino.dto.ClienteUsuarioDTORequest;
import com.Palomino.dto.ClienteUsuarioDTOResponse;



public interface ClienteUsuarioService {
	
	void guardarClienteUsuario(ClienteUsuarioDTORequest clienteUsuario);
	void actualizarClienteUsuario(ClienteUsuarioDTORequest clienteUsuario);
	void eliminarClienteUsuario(Integer id);
	List<ClienteUsuarioDTOResponse> listarClienteUsuario();
	ClienteUsuarioDTOResponse obtenerClienteUsuarioId(Integer id);

}
