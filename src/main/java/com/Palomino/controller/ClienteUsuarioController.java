package com.Palomino.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Palomino.service.ClienteUsuarioService;
import com.Palomino.dto.ClienteUsuarioDTORequest;
import com.Palomino.dto.ClienteUsuarioDTOResponse;



@Controller
@RequestMapping( path = "/clienteUsuario/v1")
public class ClienteUsuarioController {
	@Autowired
	private ClienteUsuarioService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteUsuarioDTOResponse>>  listar() {
		
		return new ResponseEntity<List<ClienteUsuarioDTOResponse>>(service.listarClienteUsuario(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteUsuarioDTORequest clienteUsuario) {
		service.guardarClienteUsuario(clienteUsuario);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ClienteUsuarioDTOResponse p =service.obtenerClienteUsuarioId(id);
		if(p != null) {
			service.eliminarClienteUsuario(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteUsuarioDTORequest clienteusuario) {
		ClienteUsuarioDTOResponse p =service.obtenerClienteUsuarioId(clienteusuario.getIdUsuario());
		if(p != null) {
			service.actualizarClienteUsuario(clienteusuario);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteUsuarioDTOResponse> obtenerId(@PathVariable Integer id) {
		ClienteUsuarioDTOResponse p =service.obtenerClienteUsuarioId(id);
		if(p != null) {
			return  new ResponseEntity<ClienteUsuarioDTOResponse>(service.obtenerClienteUsuarioId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ClienteUsuarioDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
