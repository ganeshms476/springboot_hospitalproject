package com.ty.springboot_hospital_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_project.dao.MedItemsDAO;
import com.ty.springboot_hospital_project.dao.MedOrderDAO;
import com.ty.springboot_hospital_project.dto.MedItems;
import com.ty.springboot_hospital_project.dto.MedOrder;
import com.ty.springboot_hospital_project.exception.IdNotFoundException;
import com.ty.springboot_hospital_project.exception.MedItemsNotFoundException;
import com.ty.springboot_hospital_project.exception.MedeOrderNOtFoundException;
import com.ty.springboot_hospital_project.exception.NoSuchElementException;
import com.ty.springboot_hospital_project.util.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDAO itemsDAO;

	@Autowired
	private MedOrderDAO medOrderDAO;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(int mid, MedItems items) {
		if (itemsDAO.saveMedItems(items) != null) {
			if (medOrderDAO.getMedorderById(mid) == null) {
				throw new MedeOrderNOtFoundException();
			} else {
				MedOrder medOrder = medOrderDAO.getMedorderById(mid);
				ResponseStructure<MedItems> structure = new ResponseStructure<>();

				items.setMedOrder(medOrder);
				structure.setMessage("Created");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(itemsDAO.saveMedItems(items));
				return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.CREATED);

			}
		} else {
			throw new MedItemsNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(int iid, int mid, MedItems items) {

		if (itemsDAO.updateMedItems(iid, items) != null) {
			if (medOrderDAO.getMedorderById(mid) == null) {
				throw new MedeOrderNOtFoundException();
			} else {
				MedOrder order = medOrderDAO.getMedorderById(mid);
				ResponseStructure<MedItems> structure = new ResponseStructure<>();

				items.setMedOrder(order);
				structure.setMessage("updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(itemsDAO.updateMedItems(iid, items));
				return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
			}
		} else {
			throw new MedItemsNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();

		if (itemsDAO.deleteMedItems(id) != null) {
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(itemsDAO.deleteMedItems(id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new MedItemsNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> getMedOrderById(int id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if (itemsDAO.getMedItems(id) != null) {
			structure.setMessage("fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(itemsDAO.getMedItems(id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		}else {
			throw new MedItemsNotFoundException();
		}
	}

}
