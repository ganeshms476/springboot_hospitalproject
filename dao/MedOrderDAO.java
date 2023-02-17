package com.ty.springboot_hospital_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.repository.MedOrderRepository;

@Repository
public class MedOrderDAO {

	@Autowired
	private MedOrderRepository repository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public MedOrder updateMedOrder(int id, MedOrder order) {
		if (repository.findById(id).isPresent()) {
			order.setId(id);
			return repository.save(order);
		} else {
			return null;
		}
	}
	
	public MedOrder deleteMedOrder(int id) {
		if (repository.findById(id).isPresent()) {
			MedOrder order = repository.findById(id).get();
			repository.deleteById(id);
			return order;
		} else {
			return null;
		}
	}

	public MedOrder getMedorderById(int mid) {
		if (repository.findById(mid).isPresent()) {
			return repository.findById(mid).get();
		}
		return null;
	}
	
	

}
