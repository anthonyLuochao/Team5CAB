package sg.iss.team5cab.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5cab.model.FacilityType;

public interface FacilityTypeRepository extends JpaRepository<FacilityType, String> {
	
	
}
