package sg.iss.team5cab.repo;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team5cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query("SELECT b FROM Booking b WHERE b.end_Date <=:end AND"
			+ " b.start>=:start AND b.facility.facilityID=:fID AND b.users.userID=:uID AND b.isCancel=false")
	List<Booking> findBookingDates(@Param("start") LocalDate start,@Param("end") LocalDate end,
			@Param("fID") int fID,@Param("uID") String uID);
	@Query("SELECT b FROM Booking b WHERE b.end_Date <=:end AND"
			+ " b.start>=:start AND b.facility.facilityID=:fID AND b.isCancel=false")
	List<Booking> findBookingDatesForMember(@Param("start") LocalDate start,@Param("end") LocalDate end,
			@Param("fID") int fID);
//	@Query("SELECT u FROM User u WHERE u.name=:un AND u.password=:pwd")
//	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("Select b from Booking b where b.facility.facilityID=:id")
	List<Booking> findBookingsByFacilityID(@Param("id") int fid);
	
	
}
