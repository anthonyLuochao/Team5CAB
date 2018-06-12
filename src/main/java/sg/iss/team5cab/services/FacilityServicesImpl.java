package sg.iss.team5cab.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.repo.FacilityRepository;
import sg.iss.team5cab.repo.UsersRepository;

@Service
public class FacilityServicesImpl implements FacilityServices{
	
	@Resource
	private FacilityRepository fRepo;
	private BookingService bService;
	
//	@Override
//	@Transactional	
//	public ArrayList<Facility> findAllFacilities(){	
//		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findAll();
//		return f;
//	}
	
//	@Override
//	@Transactional
//	public Facility findFacility(int fid)
//	{
//		return fRepo.findOne(fid);
//	}
	
//	@Override
//	@Transactional
//	
//	public ArrayList<Facility> findByTypeList(String typeId){		
//		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findByType(typeId);		
//		return f;
//	}
	
	@Override
	@Transactional	
	public ArrayList<Facility> findIsDamagedList(int isDamaged){		
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findIsDamaged(isDamaged);		
		return f;
	}
		
	
	@Override
	@Transactional
	public Facility createFacility(Facility fac)
	{
		return fRepo.saveAndFlush(fac);
	}
	
	
	@Override
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
	
	@Override
	@Transactional
    public boolean deleteFacility(Facility fac)
	{
		//fac.setisDeleted(true);
		if(fRepo.saveAndFlush(fac).equals(null))
		{
			return false;
		}
		else
			return true;		
		
	}
	
	@Override
	@Transactional
	public ArrayList<Facility> findFacility(String typeId,Date startDate,Date endDate,int isDamaged)
	{	
		ArrayList<Facility> result1,result2,result3,result=new ArrayList<Facility>();
	
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
	
	
	
//	@Override
//	@Transactional
//	public ArrayList<Facility> findFacilityByDateRange(LocalDate startDate,LocalDate endDate)
//	{
//		ArrayList<Facility> returnList=new ArrayList<Facility>();
//		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findAll();
//		for(Facility fac : f)
//		{
////			boolean result = bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate);
////			if(result)
////			{
////				returnList.add(fac);
////			}
//		}
//		return returnList;
//		
//	}
//	
}	


