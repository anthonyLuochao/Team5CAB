package sg.iss.team5cab.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.FacilityType;

public interface FacilityServices {
	
	//ArrayList<Facility> findAllFacilities();
	

	Facility findFacilityById(int fid);	

	
	//ArrayList<Facility> findByTypeList(String typeId);
	
//	Facility findFacilityName(String fname);
	
	ArrayList<Facility> findIsDamagedList(boolean isDamaged);
		
	Facility createFacility(Facility facility);
	
	Facility updateFacility(Facility facility);
	
	boolean deleteFacility(Facility facility);
	
	//ArrayList<Facility> findFacilityByDateRange(LocalDate startDate,LocalDate endDate);
	

	ArrayList<Facility> findFacility(String typeId,Date startDate,Date endDate,boolean isDamaged);


	

}
