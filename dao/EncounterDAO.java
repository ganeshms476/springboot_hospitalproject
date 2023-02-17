package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Encounter;
import com.ty.springboot_hospital_project.repository.EncounterRepository;

@Repository
public class EncounterDAO {

	@Autowired
	private EncounterRepository repository;

	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}

	public Encounter updateEncounter(int eid, Encounter encounter) {
		if (repository.findById(eid).isPresent()) {
			encounter.setId(eid);
			return repository.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter getEncounterByid(int eid) {
		return repository.findById(eid).get();
	}

	public Encounter deleteEncounter(int id) {
		if (repository.findById(id).isPresent()) {
			Encounter encounter = repository.findById(id).get();
			repository.deleteById(id);
			return encounter;
		} else {
			return null;
		}
	}
}
