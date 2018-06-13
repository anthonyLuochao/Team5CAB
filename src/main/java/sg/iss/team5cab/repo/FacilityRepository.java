package sg.iss.team5cab.repo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	
	@Query("SELECT f FROM Facility f where f.facilityName = :name")
	Facility findByName(@Param("name") String name);
	

	//@Query("SELECT f FROM Facility f where f.facilityType = :type")
	//ArrayList<Facility> findByType(@Param("type") String type);
	
	
	@Query("SELECT f FROM Facility f where f.isDamaged = :isDamaged")
	ArrayList<Facility> findIsDamaged(@Param("isDamaged") boolean isDamaged);

	
	@Query("SELECT f FROM Facility f where f.isDeleted = true")
	ArrayList<Facility> findIsDeleted(@Param("isDeleted")boolean isDeleted);
	
//	@Query("SELECT f FROM Facility f Inner Join Booking b on f.facilityID=b.facilityID where and f.isDamaged=false and b.start_Date =: startDate and b.end_Date=: endDate")
//    ArrayList<Facility>findIsAvailable(String typeId,Date startDate,Date endDate,boolean isDamaged);
	
	
	
}
