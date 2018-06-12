package sg.iss.team5cab.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.iss.team5cab.model.FacilityType;



public interface FacilityTypeRepository extends JpaRepository<FacilityType, String> {
	@Query("Select typeName from FacilityType")
	List<String> findTypeName(); 
	
}
