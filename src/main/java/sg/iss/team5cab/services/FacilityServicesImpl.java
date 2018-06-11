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
	//private BookingService bService;
	
	@Override
	@Transactional
	
	public ArrayList<Facility> findAllFacilities(){
		//System.out.println("yes");
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findAll();
		return f;
	}
	
	@Override
	@Transactional
	public Facility findFacility(int fid)
	{
		return fRepo.findOne(fid);
	}
	
	@Override
	@Transactional
	
	public ArrayList<Facility> findByTypeList(String typeId){		
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findByType(typeId);		
		return f;
	}
	
	@Override
	@Transactional
	
	public ArrayList<Facility> findIsDamagedList(int isDamaged){		
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findIsDamaged(isDamaged);		
		return f;
	}

//	@Override
//	@Transactional
//	public Facility findFacilityName(String fname)
//	{
//		return fRepo.findByName(fname);
//	}
		
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
	
//	@Override
//	@Transactional
//	public ArrayList<Facility> findFacility(String typeId,Date startDate,Date endDate,int isDamaged){	
//		findByTypeList(String typeId);
//		
//		
//		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findIsAvailable(typeId,startDate,endDate,isDamaged);		
//		return f;
//	}
	
	
	
	@Override
	@Transactional
	public ArrayList<Facility> findFacilityByDateRange(LocalDate startDate,LocalDate endDate)
	{
		ArrayList<Facility> returnList=new ArrayList<Facility>();
		ArrayList<Facility> f= (ArrayList<Facility>)fRepo.findAll();
		for(Facility fac : f)
		{
//			boolean result = bService.checkFacilityAvailability(fac.getFacilityID(),startDate,endDate);
//			if(result)
//			{
//				returnList.add(fac);
//			}
		}
		return returnList;
		
	}
	
}	


