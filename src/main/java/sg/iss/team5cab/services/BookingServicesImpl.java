package sg.iss.team5cab.services;

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
	public List<Booking> findBookingByAdmin(int fID,Date start,Date end,String uID)
	{
		
		 return bRepo.findAvailableDates(end,start, fID,uID);
	}
	@Transactional
	@Override
	public List<Booking> findBookingByMember(int fID,Date start,Date end)
	{
		 return bRepo.findAvailableDatesForMember(end,start, fID);
	}
	
	@Transactional
	@Override
	public void deleteBooking(int fID,Date start,Date end,String uID)
	{
		 List<Booking> b= bRepo.findAvailableDates(end,start, fID,uID);
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
	
}
