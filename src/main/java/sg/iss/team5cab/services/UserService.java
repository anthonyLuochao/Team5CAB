package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.List;

import sg.iss.team5cab.model.Users;

public interface UserService {

	ArrayList<Users> findAllUsers();
	
	Users findUser(String userid);//R
	
	Users CreateUser(Users users);//C
	
	Users changeUser(Users users);//U
	
//	void removeUser(Users username);//D
	
	Users authenticate(String userid, String password);
	
	Users findUserDetailByUID(String userid, String name );
	
	Users findUserByUID(String userid);

	void removeUser(String userid);
}
