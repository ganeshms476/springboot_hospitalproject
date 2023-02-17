package com.ty.springboot_hospital_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.AddressDAO;
import com.ty.springboot_hospital_project.dao.BranchDAO;
import com.ty.springboot_hospital_project.dao.HospitalDAO;
import com.ty.springboot_hospital_project.dto.Branch;
import com.ty.springboot_hospital_project.exception.AddressNotFoundException;
import com.ty.springboot_hospital_project.exception.BranchNotFoundException;
import com.ty.springboot_hospital_project.exception.HospitalNotFoundException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDAO dao;
	@Autowired
	private HospitalDAO hospitalDAO;

	@Autowired
	private AddressDAO addressDAO;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid, int aid) {
		if (hospitalDAO.getHospitalById(hid) != null) {
			if (addressDAO.getAddressById(aid) == null) {
				throw new AddressNotFoundException("Address Id not found");
			} else {
				ResponseStructure<Branch> structure = new ResponseStructure<>();
				structure.setMessage("Branch Saved");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dao.saveBranch(branch, hid, aid));
				return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
			}
		} else {
			throw new HospitalNotFoundException("Hospital Id not found");
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int hid, int id, Branch branch, int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (dao.updateBranch(aid, hid, id, branch) != null) {
			if (addressDAO.getAddressById(aid) == null) {
				throw new AddressNotFoundException("Address Id not found");
			} else if (hospitalDAO.getHospitalById(hid) == null) {
				throw new HospitalNotFoundException("Hospital Id not found");
			} else {
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateBranch(aid, hid, id, branch));
				return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
			}

		} else {
			throw new BranchNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (dao.deleteBranch(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException();
		}
	}

//	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHOspitalId(int id) {
//		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
//		if (dao.getAllBranchesByHospitalId() != null) {
//			structure.setMessage("Fetched");
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setData(dao.getAllBranchesByHospitalId());
//			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
//		} else {
//			throw new NoSuchElementException();
//		}
//	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		if (dao.getBranchById(id) != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getBranchById(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND);
		} else {
			throw new BranchNotFoundException();
		}

	}

}
