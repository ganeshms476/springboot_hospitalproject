package com.ty.springboot_hospital_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_project.dto.Address;
import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.dto.Hospital;
import com.ty.springboot_hospital_project.repository.BranchRepository;

@Repository
public class BranchDAO {
	@Autowired
	private BranchRepository repository;

	@Autowired
	private HospitalDAO dao;

	@Autowired
	private AddressDAO dao2;

	public Branch saveBranch(Branch branch, int hid, int aid) {
		Hospital hospital = dao.getHospitalById(hid);
		Address address = dao2.getAddressById(aid);
		if (hospital != null && address != null) {
			branch.setAddress(address);
			branch.setHospital(hospital);
			return repository.save(branch);
		} else {
			return null;
		}
	}

	public Branch updateBranch(int aid, int hid, int id, Branch branch) {
		if (repository.findById(id).isPresent()) {
			Hospital hospital = dao.getHospitalById(hid);
			Address address = dao2.getAddressById(aid);
			branch.setAddress(address);
			branch.setHospital(hospital);
			branch.setId(id);
			return repository.save(branch);
		} else {
			return null;
		}
	}

	public Branch deleteBranch(int id) {
		if (repository.findById(id).isPresent()) {
			Branch branch = repository.findById(id).get();
			repository.delete(branch);
			return branch;
		} else {
			return null;
		}
	}

//	public List<Branch> getAllBranchesByHospitalId(int id) {
//		if (dao.getHospitalById(id) != null) {
//			return repository.getBranchFromHospitalId(dao.getHospitalById(id));
//		} else {
//			return null;
//		}
//	}

	public Branch getBranchById(int id) {
		if(repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}else {
			return null;
		}
	
	}
	
	

}
