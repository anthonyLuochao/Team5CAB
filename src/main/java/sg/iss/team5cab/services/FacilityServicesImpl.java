package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

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
			returnList = new ArrayList<Facility>();
			Date epoch= new Date(0L);
			Date checkEndDate = CABDate.plusDays(CABDate.getToday(), 7);
			
			startDate = startDate.after(epoch) || startDate != null ? startDate : epoch;
			endDate = endDate.before(checkEndDate) || endDate != null ? endDate : checkEndDate;

			for (Facility f : facilityList) {
				if (bService.checkFacilityAvailability(f, startDate, endDate))
					returnList.add(f);
			}
			return returnList;
		}

//		ArrayList<Facility> result1 =new ArrayList<Facility>();
//		ArrayList<Facility> result2 =new ArrayList<Facility>();
//		ArrayList<Facility> result3 =new ArrayList<Facility>();
//		ArrayList<Facility> result =new ArrayList<Facility>();
//		
//			result1=findIsDamagedList(isDamaged);
//			result=result1;
//			System.out.println("result");
//			if(typeID!=null)
//			{
//			for(Facility fac : result1)
//			{
//				if(fac.getFacilityType().getTypeID().equals(typeID))
//				{
//					result2.add(fac);					
//				}
//			}
//			result=result2;
//			}
//			else
//			{
//				if(startDate!=null && endDate!=null)
//				{
//					for(Facility fac : result1)
//					{
//						if(bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate))
//						{
//						result3.add(fac);
//						}
//					}
//				
//				result=result3;
//				}				
//			}
//			
//			if(startDate!=null && endDate!=null)
//			{
//				for(Facility fac : result2)
//				{
//					if(bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate))
//					{
//					result3.add(fac);
//					}
//				}
//			
//			result=result3;
//			}				
//			
//			System.out.println("Executing finf facility");
//			for (Facility facility : result) {
//				System.out.println(result);
//			}
//			return result;		
	}

}	


