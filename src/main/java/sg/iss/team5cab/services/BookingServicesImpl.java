package sg.iss.team5cab.services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.repo.BookingRepository;
import sg.iss.team5cab.repo.FacilityRepository;
import utils.CABDate;

@Service
public class BookingServicesImpl implements BookingService {

	@Resource
	FacilityRepository fRepo;
	
	@Resource
	BookingRepository bRepo;
	//Screen Booking-create-update
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#createBooking(sg.iss.team5cab.model.Booking)
	 */
	@Transactional
	@Override
	public Booking createBooking(Booking booking)
	{
		 return bRepo.saveAndFlush(booking);
	}
	
	//Screen Booking-create-update
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#updateBooking(sg.iss.team5cab.model.Booking)
	 */
	@Transactional
	@Override
	public Booking updateBooking(Booking booking)
	{
		 return bRepo.saveAndFlush(booking);
		 
	}
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#findBookingByAdmin(int, java.time.LocalDate, java.time.LocalDate, java.lang.String)
	 */
	@Transactional 
	@Override
	public List<Booking> findBookingByAdmin(int fID,Date start,Date end,String uID)
	{
		
		 return bRepo.findBookingDates(end,start, fID,uID);
	}
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#findBookingByMember(int, java.time.LocalDate, java.time.LocalDate)
	 */
	@Transactional
	@Override
	public List<Booking> findBookingByMember(int fID,Date start,Date end)
	{
		 return bRepo.findBookingDatesForMember(end,start, fID);
	}
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#deleteBooking(int, java.time.LocalDate, java.time.LocalDate, java.lang.String)
	 */
	
	@Transactional
	@Override
	public Booking deleteBooking(int bookingID)
	{
		Booking book=bRepo.findOne(bookingID);
		book.setCancel(true);
		return bRepo.saveAndFlush(book);
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
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#displayAll()
	 */
	@Transactional
	@Override
	public List<Booking> displayAll()
	{
		 return (List<Booking>)bRepo.findAll();
	}
	

	
	
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#findAvailableDates(int)
	 */
	@Override
	@Transactional
	public ArrayList<Date> findAvailableDates(int fid){
		//Facility f = fRepo.findOne(fid);
		ArrayList<Booking> listOfBookingsByFid = (ArrayList<Booking>)bRepo.findBookingsByFacilityID(fid); 
		ArrayList<Date> localdatelist = new ArrayList<Date>();
		Date today = CABDate.getToday();
		
		for (int i = 0; i < 7; i++) {
			Date date = CABDate.plusDays(today, i);
			localdatelist.add(date);
			System.out.println(date.toString());
		}
		/*
		for (Date date = today; date.before(CABDate.plusDays(date, 7)); date = CABDate.plusDays(date, 1)) {
			localdatelist.add(date);
			System.out.println(date.toString());
		}*/
		
		for (Booking b : listOfBookingsByFid) {
			for (Date d : localdatelist) {
				if(d.before(b.getEndDate()) && d.after(b.getStartDate())) {
					localdatelist.remove(d);
				}
			}
		}
		return localdatelist;
		
		/*
		for (Booking b : listOfBookingsByFid) {
			for (Date date = today; date.before(CABDate.plusDays(date, 7)); date = CABDate.plusDays(date, 1)) {
				if(date.before(b.getEndDate()) && date.after(b.getStartDate())) {
					localdatelist.remove(date);
				}
			}	
		}*/
		
	}
	
	/* (non-Javadoc)
	 * @see sg.iss.team5cab.services.BookingService#isBookingClash(int, java.time.LocalDate, java.time.LocalDate)
	 */
	@Override
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
	@Override
	@Transactional
	public List<Integer> findAllFacilityID()
	{
		return bRepo.findAllFacilityID();
	}
	@Override
	@Transactional
	public Booking findBookingByID(int ID)
	{
		return bRepo.findOne(ID);
	}
}
