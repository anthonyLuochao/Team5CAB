package sg.iss.team5cab.repo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	
	@Query("SELECT f FROM Facility f where f.facilityname = :name")
	Facility findByName(@Param("name") String name);
	
	@Query("SELECT f FROM Facility f where f.typeID = : type")
	ArrayList<Facility> findByType(@Param("type") String type);
	
	@Query("SELECT f FROM Facility f where f.isDamaged = 1")
	ArrayList<Facility> findIsDamaged(int isDamaged);
	
	@Query("SELECT f FROM Facility f where f.isDeleted = 0")
	ArrayList<Facility> findIsDeleted(int isDeleted);
	
	@Query("SELECT f FROM Facility f Inner Join Booking b on f.facilityID=b.facilityID where f.typeID=:type and f.isDamaged=0 and b.start_Date =: startDate and b.end_Date=: endDate")
    ArrayList<Facility>findIsAvailable(String typeId,Date startDate,Date endDate,int isDamaged);
	
	
}
