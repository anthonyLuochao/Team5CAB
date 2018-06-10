package sg.iss.team5cab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5cab.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
