package sg.iss.team5cab.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.team5cab.repo.FacilityRepository;

@Service
public class BookingServicesImpl {
	@Resource
	FacilityRepository fRepo;
	
	//@Transactional DAO methods that uses JPARepo

}
