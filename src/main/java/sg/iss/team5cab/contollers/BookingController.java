package sg.iss.team5cab.contollers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.BookingService;
import sg.iss.team5cab.services.FacilityServices;
import sg.iss.team5cab.services.FacilityTypeService;
import sg.iss.team5cab.services.UsersService;

@Controller
public class BookingController {
	@Autowired
	BookingService bService;

	@Autowired
	UsersService uService;
	
	@Autowired
	FacilityTypeService ftService;
	
	@Autowired
	FacilityServices fService;
	

	@RequestMapping(value = {"/admin/booking/create/{facilityID}","/member/booking/create/{facilityID}"},
			method = RequestMethod.GET)
	public ModelAndView newBookingPage(@PathVariable("facilityID") int facilityID,
			HttpSession session) {
		// get the user id from session scope
		
		Booking booking = new Booking();
		String userID = session.getAttribute("userID").toString();
		Users user = uService.findUser(userID);
		booking.setUsers(user);
		Facility f = fService.findFacilityById(facilityID);
		booking.setFacility(f);

		ModelAndView mav = new ModelAndView("booking-create-update", "booking", booking);
		mav.addObject("availableDateList", bService.findUnavailableDates(facilityID));
		return mav;
	}
	

	@RequestMapping(value = {"/admin/booking/create/{facilityID}","/member/booking/create/{facilityID}"} ,
		method = RequestMethod.POST)
	public ModelAndView newBookingPage(@ModelAttribute Booking booking,
			HttpSession session)
	{
		
		String userID = session.getAttribute("userID").toString();
		int fid = booking.getFacility().getFacilityID();
		Date startDate = booking.getStartDate();
		Date endDate = booking.getEndDate();

		
		if(bService.isBookingClash(fid, startDate, endDate)){
			//some error feedback
			
			ModelAndView mav= new ModelAndView("booking-create-update", "booking", booking);
			mav.addObject("bookingWarning", true);
			return mav;
					
		}
		else{
			Facility f = fService.findFacilityById(booking.getFacility().getFacilityID());
			booking.setFacility(f);
			booking.setUsers(uService.findUser(userID));
			if(booking.getEndDate()==null)
				booking.setEndDate(booking.getStartDate());
			
			bService.createBooking(booking);
			return new ModelAndView("booking-confirmation", "booking", booking);
		}	

	}
	

	
	@RequestMapping(value= {"/admin/booking/search", "/member/booking/search"},method=RequestMethod.GET)
	public ModelAndView createSearchPage()
	{
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("booking",new Booking());
		mav.addObject("listOfTypeName",ftService.findAllType());
		//mav.addObject("listOfFacilityID",bService.findAllFacilityID());
		mav.setViewName("booking-search");
		return mav;
	}
	
	@RequestMapping(value="/admin/booking/search",method=RequestMethod.POST)
	public ModelAndView displaySearchResult(@ModelAttribute("booking") Booking booking)
	{
		ModelAndView mav=new ModelAndView();
		List<Booking> listBookings=bService.findBookingByTypeName(booking.getFacility().getFacilityType().getTypeName(), booking.getStartDate(), booking.getEndDate(), booking.getUsers().getUserID());
		mav.addObject("bookings",listBookings);
		mav.addObject("listOfTypeName",ftService.findAllType());
		mav.setViewName("booking-search");
		return mav;
	}
	
	@RequestMapping(value="/member/booking/search",method=RequestMethod.POST)
	public ModelAndView displayMemberSearchResult(@ModelAttribute("booking") Booking booking)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("booking-search");
		return mav;
	}
	
	@RequestMapping(value="/admin/booking/edit/{bookingID}",method = RequestMethod.GET)
    public ModelAndView editBooking(@PathVariable int bookingID)
    {
		Booking booking  = bService.findBookingByID(bookingID);
		ModelAndView mav = new ModelAndView("booking-edit", "booking", booking);
		
		return mav;
    }

	@RequestMapping(value="/admin/booking/edit",method = RequestMethod.POST)
    public ModelAndView editBookingConfirmation(@ModelAttribute("booking") Booking updatedBooking)

    {
//		System.out.println(updatedBooking);
		Booking oldBooking=bService.findBookingByID(updatedBooking.getBookingID());
		
		oldBooking.setStartDate(updatedBooking.getStartDate());
		oldBooking.setEndDate(updatedBooking.getEndDate());
//		
//		updatedBooking.setIsCancel(oldBooking.getIsCancel());
//		//updatedBooking.setBookingID(oldBooking.getBookingID());
//		updatedBooking.setFacility(oldBooking.getFacility());
//		updatedBooking.setUnderMaintenance(oldBooking.getIsUnderMaintenance());
//		updatedBooking.getUsers().setUserID(oldBooking.getUsers().getUserID());
		
    	ModelAndView mav =new ModelAndView("booking-confirmation", "booking", bService.updateBooking(oldBooking));
       	return mav;
    }
	
	@RequestMapping(value="/admin/booking/delete/{bookingID}",method=RequestMethod.GET)
	public ModelAndView deleteBooking(@PathVariable int bookingID)
	{
		Booking book=bService.findBookingByID(bookingID);
		bService.deleteBooking(bookingID);
		return new ModelAndView("redirect:/admin/booking/search");
	}
	

	

}