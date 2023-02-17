package com.ty.springboot_hospital_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.BranchDAO;
import com.ty.springboot_hospital_project.dao.EncounterDAO;
import com.ty.springboot_hospital_project.dao.PersonDAO;
import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.dto.Person;
import com.ty.springboot_hospital_project.exception.BranchNotFoundException;
import com.ty.springboot_hospital_project.exception.EncounterNotFoundException;
import com.ty.springboot_hospital_project.exception.PersonNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDAO encounterDAO;
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private BranchDAO branchDAO;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		if (encounterDAO.saveEncounter(encounter) != null)

		{
			if (personDAO.getPersonById(pid) == null) {
				throw new PersonNotFoundException();
			} else if (branchDAO.getBranchById(bid) == null) {
				throw new BranchNotFoundException();
			} else {
				Person person = personDAO.getPersonById(pid);
				Branch branch = branchDAO.getBranchById(bid);

				List<Branch> list = new ArrayList<>();
				list.add(branch);
				encounter.setPerson(person);
				encounter.setBranchs(list);

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("Created");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(encounterDAO.saveEncounter(encounter));
				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);
			}
		} else {
			throw new EncounterNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int eid, Encounter encounter, int bid) {

		if (encounterDAO.updateEncounter(eid, encounter) != null) {
			if (branchDAO.getBranchById(bid) == null) {
				throw new BranchNotFoundException();
			} else {
				Encounter encounter2 = encounterDAO.getEncounterByid(eid);
				Branch branch = branchDAO.getBranchById(bid);

				List<Branch> branchs = encounter2.getBranchs();
				branchs.add(branch);

				encounter.setPerson(encounter2.getPerson());
				encounter.setBranchs(branchs);

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(encounterDAO.updateEncounter(eid, encounter));
				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
			}
		} else {
			throw new EncounterNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();

		if (encounterDAO.deleteEncounter(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounterDAO.deleteEncounter(id));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new EncounterNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		if (encounterDAO.getEncounterByid(id) != null) {
			structure.setMessage("fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounterDAO.getEncounterByid(id));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new EncounterNotFoundException();
		}
	}
}
