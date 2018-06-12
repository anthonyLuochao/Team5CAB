package sg.iss.team5cab.services;

import java.util.List;

import sg.iss.team5cab.model.FacilityType;

public interface FacilityTypeService {

	List<FacilityType> findAll();

	List<String> findAllType();


}
