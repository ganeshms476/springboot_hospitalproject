package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.repository.MedItemsRepository;

@Repository
public class MedItemsDAO {

	@Autowired
	private MedItemsRepository repository;
	
	
	public MedItems saveMedItems(MedItems items) {
		return repository.save(items);
	}
	
	public MedItems updateMedItems(int iid,MedItems items) {
		if(repository.findById(iid).isPresent()) {
			items.setId(iid);
			return repository.save(items);
		}else {
			return null;
		}
	}
	
	public MedItems deleteMedItems(int id) {
		if (repository.findById(id).isPresent()) {
			MedItems items = repository.findById(id).get();
			repository.deleteById(id);
			return items;
		} else {
			return null;
		}
	}
	
	public MedItems getMedItems(int id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}
		return null;
	}
}
