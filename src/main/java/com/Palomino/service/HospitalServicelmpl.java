package com.Palomino.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Palomino.dto.HospitalDTORequest;
import com.Palomino.dto.HospitalDTOResponse;
import com.Palomino.model.Hospital;
import com.Palomino.repository.HospitalRepository;

@Service
public class HospitalServicelmpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital p = new Hospital();
		p.setNombre(hospital.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setDistrito(hospital.getDescripcion());
		repository.save(p);
		
	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
		Hospital p = new Hospital();
		p.setNombre(hospital.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setDistrito(hospital.getDescripcion());
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> p = repository.findAll();
		
		for (Hospital hospital : p) {
			
			dto = new HospitalDTOResponse();
			
			dto.setNombre(hospital.getNombre());
			dto.setDescripcion(hospital.getDescripcion());
			dto.setDistrito(hospital.getDistrito());
		
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospital(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setNombre(hospital.getNombre());
		dto.setDescripcion(hospital.getDescripcion());
		dto.setDistrito(hospital.getDistrito());
		
		return dto;

	}

}
