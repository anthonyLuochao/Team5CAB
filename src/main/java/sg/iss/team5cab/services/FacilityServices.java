package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.FacilityType;


public interface FacilityServices {

	
	Facility findFacilityById(int id);
	
	ArrayList<Facility> findIsDamagedList(boolean isDamaged);
		
	Facility createFacility(Facility facility);
	
	Facility updateFacility(Facility facility);
	
	boolean deleteFacility(Facility facility);
	
	ArrayList<Facility> findFacility(FacilityType ft,Date startDate,Date endDate,boolean isDamaged);


	List<Integer> findFacilityIDByTypeName(String typeName);	


}

