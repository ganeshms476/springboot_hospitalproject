package com.ty.springboot_hospital_project.service;

import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.springboot_hospital_project.dao.HospitalDAO;
import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.exception.HospitalNotFoundException;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDAO dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveHospital(hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (dao.updateHospital(id, hospital) != null) {
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateHospital(id, hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (dao.deleteHospital(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteHospital(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (dao.getHospitalById(id) != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getHospitalById(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		}else {
			throw new HospitalNotFoundException();
		}
	}

}
