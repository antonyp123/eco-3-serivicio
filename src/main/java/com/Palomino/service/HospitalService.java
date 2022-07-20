package com.Palomino.service;

import java.util.List;

import com.Palomino.dto.HospitalDTORequest;
import com.Palomino.dto.HospitalDTOResponse;



public interface HospitalService {
	void guardarHospital(HospitalDTORequest clienteUsuario);
	void actualizarHospital(HospitalDTORequest clienteUsuario);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospital(Integer id);

}
