package sg.iss.team5cab.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.iss.team5cab.model.Booking;

public interface BookingService {

	//Screen Booking-create-update
	Booking createBooking(Booking booking);

	//Screen Booking-create-update
	Booking updateBooking(Booking booking);
	List<Booking> findBookingByMember(int fID, Date start, Date end);
	List<Booking> findBookingByAdmin(int fID, Date start, Date end, String uID);
	
	boolean checkFacilityAvailability(int fID, Date start, Date end);


	List<Booking> displayAll();

	ArrayList<Date> findAvailableDates(int fid);

	boolean isBookingClash(int fid, Date startDate, Date endDate);
	List<Integer> findAllFacilityID();

	Booking findBookingByID(int ID);

	Booking deleteBooking(int bookingID);

	List<Booking> findAllBooking();

	List<Booking> findBookingByTypeName(String typeName, Date start, Date end, String uID);

}
