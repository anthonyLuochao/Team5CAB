package sg.iss.team5cab.services;


import java.util.Date;
import java.util.List;

import sg.iss.team5cab.model.Booking;

public interface BookingService {
	Booking createBooking(Booking booking);
	Booking updateBooking(Booking booking);
	List<Booking> displayAll();
	List<Booking> findBookingByMember(int fID, Date start, Date end);
	List<Booking> findBookingByAdmin(int fID, Date start, Date end, String uID);
	void deleteBooking(int fID, Date start, Date end, String uID);
	boolean checkFacilityAvailability(int fID, Date start, Date end);
}
