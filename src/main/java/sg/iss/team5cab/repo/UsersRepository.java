package sg.iss.team5cab.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	@Query("select u from Users u where isDeleted=false")
	ArrayList<Users> findAllExceptDeleted();
	
	@Query("select u from Users u where (userID like %:userID% or name like %:name%) and isDeleted=false")
	ArrayList<Users> findUsersByIdOrName(@Param("userID") String userid,@Param("name") String name);
	
	@Query("Select u from Users u where u.userID= :userID and u.password= :password and isDeleted=false")
	Users findUserByNamePwd(@Param("userID") String userid, @Param("password") String password);
	
	@Query("select u from Users u where userID= :userID and isDeleted=false")
	Users findUserByUID(@Param("userID") String userID);
}
