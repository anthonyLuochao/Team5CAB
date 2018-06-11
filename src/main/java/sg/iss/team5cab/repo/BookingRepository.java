package sg.iss.team5cab.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sg.iss.team5cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query("SELECT b FROM Booking b,Facility f,Users u WHERE b.end_Date <=:end AND"
			+ " b.start>=:start AND f.facilityID=:fID AND u.userID=:uID AND b.isCancel=false")
	List<Booking> findAvailableDates(@Param("start") Date start,@Param("end") Date end,
			@Param("fID") int fID,@Param("uID") String uID);
	@Query("SELECT b FROM Booking b,Facility f,Users u WHERE b.end_Date <=:end AND"
			+ " b.start>=:start AND f.facilityID=:fID AND b.isCancel=false")
	List<Booking> findAvailableDatesForMember(@Param("start") Date start,@Param("end") Date end,
			@Param("fID") int fID);
//	@Query("SELECT u FROM User u WHERE u.name=:un AND u.password=:pwd")
//	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("Select b from Booking b where b.facilityID=:id")
	List<Booking> findBookingsByFacilityID(@Param("id") int fid);
	
}
