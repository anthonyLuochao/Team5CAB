package sg.iss.team5cab.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.FacilityType;
 public interface FacilityTypeRepository extends JpaRepository<FacilityType,String>{
	
	@Query("Select typeID from FacilityType")
	List<String>findTypeID(); 
}
