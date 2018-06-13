package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.repo.FacilityRepository;

@Service
public class FacilityServicesImpl{// implements FacilityService{
	
	@Resource
	private FacilityRepository fRepo;
	private BookingService bService;
	
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#findFacilityById(int)
	 */

	@Transactional
	public Facility findFacilityById(int id){
		return fRepo.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#findIsDamagedList(boolean)
	 */

	@Transactional
	public ArrayList<Facility> findIsDamagedList(boolean isDamaged){		
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findIsDamaged(isDamaged);		
		return f;
	}
		
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#createFacility(sg.iss.team5cab.model.Facility)
	 */

	@Transactional
	public Facility createFacility(Facility fac)
	{
		return fRepo.saveAndFlush(fac);
	}
	
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#updateFacility(sg.iss.team5cab.model.Facility)
	 */

	@Transactional
	public Facility updateFacility(Facility fac)
	{
		return fRepo.saveAndFlush(fac);
	}
	
//	@Override
//	@Transactional
//	public void deleteFacility(Facility fac)
//	{
//		fRepo.delete(fac);
//	}
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#deleteFacility(sg.iss.team5cab.model.Facility)
	 */

	@Transactional
    public boolean deleteFacility(Facility fac)
	{
		fac.setIsDeleted(true);
		if(fRepo.saveAndFlush(fac).equals(null))
		{
			return false;
		}
		else
			return true;		
		
	}
	
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.FacilityService#findFacility(java.lang.String, java.util.Date, java.util.Date, boolean)
	 */

	@Transactional
	public ArrayList<Facility> findFacility(String typeId,Date startDate,Date endDate,boolean isDamaged)
	{	
		ArrayList<Facility> result1 =new ArrayList<Facility>();
		ArrayList<Facility> result2 =new ArrayList<Facility>();
		ArrayList<Facility> result3 =new ArrayList<Facility>();
		ArrayList<Facility> result =new ArrayList<Facility>();
		
			result1=findIsDamagedList(isDamaged);
			result=result1;
			
			if(typeId!=null)
			{
			for(Facility fac : result1)
			{
				if(fac.getFacilityType().equals(typeId))
				{
					result2.add(fac);					
				}
			}
			result=result2;
			}
			else
			{
				if(startDate!=null && endDate!=null)
				{
					for(Facility fac : result1)
					{
						if(bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate))
						{
						result3.add(fac);
						}
					}
				
				result=result3;
				}				
			}
			
			if(startDate!=null && endDate!=null)
			{
				for(Facility fac : result2)
				{
					if(bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate))
					{
					result3.add(fac);
					}
				}
			
			result=result3;
			}				
	
			return result;		
	}

	
	
	

}	


