package com.Palomino.service;

import java.util.List;

import com.Palomino.dto.ClienteDTORequest;
import com.Palomino.dto.ClienteDTOResponse;


public interface ClienteService {

	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarCliente();
	ClienteDTOResponse obtenerClienteId(Integer id);
}
