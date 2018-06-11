package sg.iss.team5cab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	@Query("select u from Users u where userID like %:userID% or name like %:name%")
//	@Query("select u from users u where userID =: userID or name=: name")
	Users findUserDetailByUID(@Param("userID") String userid,@Param("name") String name);
	
	@Query("Select u from Users u where u.userID= :userID and u.password= :password")
	Users findUserByNamePwd(@Param("userID") String userid, @Param("password") String password);
	
	@Query("select u from Users u where userID= :userID")
	Users findUserByUID(@Param("userID") String userID);
	
	

}
