package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.repo.UsersRepository;

@Service
public class UsersServicesImpl implements UsersService {
	
	@Resource
	UsersRepository uRepo;
	
    public ArrayList<Users> findAllUsers()
    {
		ArrayList<Users> ul = (ArrayList<Users>) uRepo.findAllExceptDeleted();
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
		u.setIsDeleted(true);
		uRepo.saveAndFlush(u);
	}

	@Override
	public Users authenticate(String userid, String password) {
		// TODO Auto-generated method stub
		Users u = uRepo.findUserByNamePwd(userid, password);
		return u;
	}

	@Override
	public ArrayList<Users> findUsersByIdOrName(String userid, String name) {
		// TODO Auto-generated method stub
		return uRepo.findUsersByIdOrName(userid, name);
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
