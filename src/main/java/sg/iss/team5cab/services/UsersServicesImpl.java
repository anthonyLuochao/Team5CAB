package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.repo.UsersRepository;

@Service
public class UsersServicesImpl implements UsersService {
	
	@Resource
	UsersRepository uRepo;
	
//	@Transactional DAO methods that uses JPARepo

//    public Users createUser(Users users) {
//		
//    	return UsersRepository.saveAndFlush(users);
//	}
    public ArrayList<Users> findAllUsers()
    {
		ArrayList<Users> ul = (ArrayList<Users>) uRepo.findAll();
    	return ul;
    	
    }

	@Override
	public Users findUser(String userid) {
		// TODO Auto-generated method stub
		return uRepo.findOne(userid);
	}

	@Override
	public Users CreateUser(Users users) {
		// TODO Auto-generated method stub
		return uRepo.saveAndFlush(users);
	}

	@Override
	public Users changeUser(Users users) {
		// TODO Auto-generated method stub
		return uRepo.saveAndFlush(users);
	}

	@Override
	public void removeUser(String userid) {
		// TODO Auto-generated method stub
		Users u = uRepo.findOne(userid);
		u.setRole("");
		uRepo.saveAndFlush(u);
	}

	@Override
	public Users authenticate(String userid, String password) {
		// TODO Auto-generated method stub
		Users u = uRepo.findUserByNamePwd(userid, password);
		return u;
	}

	@Override
	public Users findUserDetailByUID(String userid, String name) {
		// TODO Auto-generated method stub
		Users u = uRepo.findUserDetailByUID(userid, name);
		return u;
	}

	@Override
	public Users findUserByUID(String userid) {
		// TODO Auto-generated method stub
		Users u = uRepo.findUserByUID(userid);
		return u;
	}

	public String RandomPassword() {
		return UUID.randomUUID().toString();
	}
}
