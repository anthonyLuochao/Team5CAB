package sg.iss.team5cab.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.FacilityType;
import sg.iss.team5cab.repo.FacilityTypeRepository;


@Service
public class FacilityTypeServiceImpl implements FacilityTypeService{
	@Resource
	FacilityTypeRepository ftRepo;
	
	@Transactional
	@Override
	public List<FacilityType> findAll()
	{
		
		 return (List<FacilityType>)ftRepo.findAll();
	}
	@Transactional
	@Override
	public List<String> findAllType()
	{
		return (List<String>)ftRepo.findTypeName();
	}
	

}
