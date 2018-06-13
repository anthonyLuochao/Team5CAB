package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.FacilityType;
import sg.iss.team5cab.repo.FacilityRepository;
import utils.CABDate;

@Service
public class FacilityServicesImpl implements FacilityServices{
	
	@Resource
	private FacilityRepository fRepo;
	
	@Autowired
	private BookingService bService;
	
	
	@Override
	@Transactional
	public Facility findFacilityById(int id){
		return fRepo.findOne(id);
	}
	
	@Override
	@Transactional
	public ArrayList<Facility> findIsDamagedList(boolean isDamaged){		
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findIsDamaged(isDamaged);		
		return f;
	}
		
	
	@Override
	@Transactional
	public Facility createFacility(Facility fac)
	{
		System.out.println("facility:"+fac.toString());
		return fRepo.saveAndFlush(fac);
	}
	
	
	@Override
	@Transactional
	public Facility updateFacility(Facility fac)
	{
		return fRepo.saveAndFlush(fac);
	}
	
    @Override
	@Transactional
    public boolean deleteFacility(Facility fac)
	{
		Facility f = fRepo.findOne(fac.getFacilityID());
		
		f.setIsDeleted(true);
		if(fRepo.saveAndFlush(fac).equals(null))
		{
			return false;
		}
		else
			return true;		
		
	}
	
	
	@Override
	@Transactional
	public ArrayList<Facility> findFacility(FacilityType ft, Date startDate,Date endDate,boolean isDamaged)
	{	
		ArrayList<Facility> facilityList;
		ArrayList<Facility> returnList;
		
		if (ft == null) // when no typeID is requested
			facilityList = fRepo.findIsDamaged(isDamaged);
		else
			facilityList = fRepo.findIsDamagedOfType(isDamaged,  ft);
		if (startDate == null && endDate == null) 
			return facilityList;
		else {
			System.out.println(facilityList.size());
			returnList = new ArrayList<Facility>();

			for (Facility f : facilityList) {
				if (bService.checkFacilityAvailability(f, startDate, endDate))
					returnList.add(f);
			}
			return returnList;
		}
	}

	@Override
	public ArrayList<Facility> findFacility(String typeId, Date startDate, Date endDate, boolean isDamaged) {
		// TODO Auto-generated method stub
		return null;
	}
}	
