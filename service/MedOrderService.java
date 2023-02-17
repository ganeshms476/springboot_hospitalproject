package com.ty.springboot_hospital_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.EncounterDAO;
import com.ty.springboot_hospital_project.dao.MedOrderDAO;
import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.NoSuchElementException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDAO medOrderDAO;

	@Autowired
	private EncounterDAO encounterDAO;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(int eid, MedOrder medOrder) {
		Encounter encounter = encounterDAO.getEncounterByid(eid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
			medOrder.setEncounter(encounter);
			structure.setMessage("Created");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medOrderDAO.saveMedOrder(medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(int eid, int mid, MedOrder medOrder) {
		Encounter encounter = encounterDAO.getEncounterByid(eid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();

		if (medOrderDAO.updateMedOrder(mid, medOrder) != null) {
			medOrder.setEncounter(encounter);
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrderDAO.updateMedOrder(mid, medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();

		if (medOrderDAO.deleteMedOrder(id)!= null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrderDAO.deleteMedOrder(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id){
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (medOrderDAO.getMedorderById(id) != null) {
			structure.setMessage("fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrderDAO.getMedorderById(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		}else {
			throw new NoSuchElementException();
		}
	}

}
