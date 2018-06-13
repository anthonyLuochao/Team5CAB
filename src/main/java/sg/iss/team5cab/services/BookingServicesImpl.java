package sg.iss.team5cab.services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.repo.BookingRepository;
import utils.CABDate;

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
		
		 return bRepo.findBookingDates(end,start, fID,uID);
	}
	@Transactional
	@Override
	public List<Booking> findBookingByMember(int fID,Date start,Date end)
	{
		 return bRepo.findBookingDatesForMember(end,start, fID);
	}
	
	@Transactional
	@Override
	public void deleteBooking(int fID,Date start,Date end,String uID)
	{
		 List<Booking> b= bRepo.findBookingDates(end,start, fID,uID);
		 for(Booking book:b)
		 {
			 book.setCancel(true);
			 bRepo.saveAndFlush(book);
		 }
	}

	@Transactional
	@Override
	public boolean checkFacilityAvailability(Facility f, Date start, Date end) {
		ArrayList<Booking> bookings;
		
		// Availability should only be checked between today and X days from today.
		Date today = CABDate.getToday();
		Date checkEndDate = CABDate.plusDays(today, 7);
		start = start.before(today) ? today : start;
		end = end.after(checkEndDate) ? checkEndDate : end;

		// get all bookings between start and end date, including those at include the start and end date

		bookings = bRepo.findBookingsBetweenStartAndEndDateInclusiveByFacility(start, end, f);
		
		System.out.println(bookings.size());
		
		ArrayList<Date> dates = BookingDatesToDateList(bookings);
		Date checkDate = dates.get(0);
		// If, during the loop, the current checkDate is before the date compared in the list
		// return true as there the current checkDate is available for booking.
		for (Date date : dates) {
			if (checkDate.before(date))
				return true;
			else
				CABDate.plusDays(checkDate, 1);
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean checkFacilityAvailability(int fID,Date start,Date end)
	{
		//if there is no fID in booking record,then available
		boolean result=false;
		List<Booking> bookingList=bRepo.findBookingsByFacilityID(fID);
		if(bookingList==null)
		{
			result= true;
		}
		else//if fID is inside booking record then check if start and end day frame
			//is within each test record
		{
			Calendar c = Calendar.getInstance();
			List<Date> bookedDates=new ArrayList<Date>();
			for (Date date = start; date.equals(end); CABDate.plusDays(date, 1))  {
				bookedDates.add(date);
			}
			//save each day from start to end to a list. then traverse through each booking duration.
			//delete all matching booking record from the created list.if at end of day,the list is empty then not available
			for(Booking b:bookingList)
			{
				if((b.getStartDate().before(start)||b.getStartDate().equals(start))&&(b.getEndDate().equals(end)||b.getEndDate().after(end)))
				{result= false;}
				else
				{
					for(Date date=b.getStartDate();date.equals(end);CABDate.plusDays(date, 1))
					{
						bookedDates.remove(date);
					}
				}
			}
			if(bookedDates.isEmpty())
				result=false;
		}
		return result;
	}
	
	
	//@Transactional DAO methods that uses JPARepo
	@Transactional
	@Override
	public List<Booking> displayAll()
	{
		 return bRepo.findAll();
	}
	

	Date today = CABDate.getToday();
	
	
	@Transactional
	public ArrayList<Date> findAvailableDates(int fid){
		ArrayList<Booking> listOfBookingsByFid = (ArrayList<Booking>)bRepo.findBookingsByFacilityID(fid); 
		ArrayList<Date> localdatelist = new ArrayList<Date>();
		
		for (Date date = today; date.before(CABDate.plusDays(date, 7)); date = CABDate.plusDays(date, 1)) {
			localdatelist.add(date);
		}
		
		for (Booking b : listOfBookingsByFid) {
			for (Date date = today; date.before(CABDate.plusDays(date, 7)); date = CABDate.plusDays(date, 1)) {
				if(date.before(b.getEndDate()) && date.after(b.getStartDate())) {
					localdatelist.remove(date);
				}
			}	
		}
		return localdatelist;
	}
	
	@Transactional
	public boolean isBookingClash(int fid, Date startDate, Date endDate) {
		ArrayList<Booking> listOfBookingsByFid = (ArrayList<Booking>)bRepo.findBookingsByFacilityID(fid); 
		for (Date date = startDate; date.before(endDate); date = CABDate.plusDays(date, 1)) {
			for (Booking b : listOfBookingsByFid) {
				if(date.before(b.getEndDate()) && date.after(b.getStartDate())){
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Date> BookingDatesToDateList(List<Booking> bookings) {
		ArrayList<Date> dates = new ArrayList<Date>();
		for (Booking b : bookings) {
			for (Date date = b.getStartDate(); !date.equals(b.getEndDate()); CABDate.plusDays(date, 1)) {
				dates.add(date);
			}
		}
		return dates;
	}
}
