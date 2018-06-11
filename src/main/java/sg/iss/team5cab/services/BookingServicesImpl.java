package sg.iss.team5cab.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.repo.BookingRepository;

@Service
public class BookingServicesImpl implements BookingService {

	@Resource
	BookingRepository bRepo;
	//Screen Booking-create-update
	@Transactional
	@Override
	public Booking createBooking(Booking booking)
	{
		 return bRepo.saveAndFlush(booking);
	}
	
	//Screen Booking-create-update
	@Transactional
	@Override
	public Booking updateBooking(Booking booking)
	{
		 return bRepo.saveAndFlush(booking);
	}
	
	@Transactional
	@Override
	public List<Booking> findBookingByAdmin(int fID,LocalDate start,LocalDate end,String uID)
	{
		
		 return bRepo.findBookingDates(end,start, fID,uID);
	}
	@Transactional
	@Override
	public List<Booking> findBookingByMember(int fID,LocalDate start,LocalDate end)
	{
		 return bRepo.findBookingDatesForMember(end,start, fID);
	}
	
	@Transactional
	@Override
	public void deleteBooking(int fID,LocalDate start,LocalDate end,String uID)
	{
		 List<Booking> b= bRepo.findBookingDates(end,start, fID,uID);
		 for(Booking book:b)
		 {
			 book.setCancel(true);
			 bRepo.saveAndFlush(book);
		 }
	}
//	@Transactional
//	@Override
//	public boolean checkFacilityAvailability(int fID,Date start,Date end)
//	{
//		if(fID==bRepo.)
//	}
	
	
	
	
	//@Transactional DAO methods that uses JPARepo
	@Transactional
	@Override
	public List<Booking> displayAll()
	{
		 return bRepo.findAll();
	}
	

	LocalDate today = LocalDate.now();
	
	
	@Transactional
	public ArrayList<LocalDate> findAvailableDates(int fid){
		ArrayList<Booking> listOfBookingsByFid = (ArrayList<Booking>)bRepo.findBookingsByFacilityID(fid); 
		ArrayList<LocalDate> localdatelist = new ArrayList<LocalDate>();
		
		for (LocalDate date = today; date.isBefore(today.plusDays(7)); date = today.plusDays(1)) {
			localdatelist.add(date);
		}
		
		for (Booking b : listOfBookingsByFid) {
			for (LocalDate date = today; date.isBefore(today.plusDays(7)); date = today.plusDays(1)) {
				if(date.isBefore(b.getEndDate()) && date.isAfter(b.getStartDate())) {
					localdatelist.remove(date);
				}
			}	
		}
		return localdatelist;
	}
	
	@Transactional
	public boolean isBookingClash(int fid, LocalDate startDate, LocalDate endDate) {
		ArrayList<Booking> listOfBookingsByFid = (ArrayList<Booking>)bRepo.findBookingsByFacilityID(fid); 
		for (LocalDate date = startDate; date.isBefore(endDate); date = today.plusDays(1)) {
			for (Booking b : listOfBookingsByFid) {
				if(date.isBefore(b.getEndDate()) && date.isAfter(b.getStartDate())){
					return true;
				}
			}
		}
		return false;
	}
}
