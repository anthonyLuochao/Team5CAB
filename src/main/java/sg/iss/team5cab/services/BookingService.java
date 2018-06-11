package sg.iss.team5cab.services;


import java.time.LocalDate;
import java.util.List;

import sg.iss.team5cab.model.Booking;

public interface BookingService {
	Booking createBooking(Booking booking);
	Booking updateBooking(Booking booking);
	List<Booking> displayAll();
	List<Booking> findBookingByMember(int fID, LocalDate start, LocalDate end);
	List<Booking> findBookingByAdmin(int fID, LocalDate start, LocalDate end, String uID);
	void deleteBooking(int fID, LocalDate start, LocalDate end, String uID);
	boolean checkFacilityAvailability(int fID, LocalDate start, LocalDate end);
}
