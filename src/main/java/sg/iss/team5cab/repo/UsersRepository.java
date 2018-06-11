package sg.iss.team5cab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	@Query("select u from Users u where userid like %:userid% or name like %:name%")
//	@Query("select u from users u where userid =: userid or name=: name")
	Users findUserDetailByUID(@Param("userid") String userid,@Param("name") String name);
	
	@Query("Select u from users u where u.userid=:un and u.password=:pwd")
	Users findUserByNamePwd(@Param("un") String userid, @Param("pwd") String password);
	
	@Query("select userid from Users u where userid=: userid")
	Users findUserByUID(@Param("userid") String userid);
	
	

}
