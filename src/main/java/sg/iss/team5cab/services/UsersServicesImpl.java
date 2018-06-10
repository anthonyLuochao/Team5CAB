package sg.iss.team5cab.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.team5cab.repo.UsersRepository;

@Service
public class UsersServicesImpl {
	
	@Resource
	UsersRepository uRepo;
	
	//@Transactional DAO methods that uses JPARepo

}
