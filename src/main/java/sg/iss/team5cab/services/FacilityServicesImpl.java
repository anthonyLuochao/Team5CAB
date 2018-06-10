package sg.iss.team5cab.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.team5cab.repo.FacilityRepository;
import sg.iss.team5cab.repo.UsersRepository;

@Service
public class FacilityServicesImpl {
	
	@Resource
	FacilityRepository fRepo;
	
	//@Transactional DAO methods that uses JPARepo

}
