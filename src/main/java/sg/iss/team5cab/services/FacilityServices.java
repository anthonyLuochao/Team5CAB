package sg.iss.team5cab.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import sg.iss.team5cab.model.Facility;

public interface FacilityServices {

	
	Facility findFacilityById(int id);
	
	ArrayList<Facility> findIsDamagedList(boolean isDamaged);
		
	Facility createFacility(Facility facility);
	
	Facility updateFacility(Facility facility);
	
	boolean deleteFacility(Facility facility);
	

	ArrayList<Facility> findFacility(String typeId, Date startDate, Date endDate, boolean isDamaged);
	

}
