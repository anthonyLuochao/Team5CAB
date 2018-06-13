package sg.iss.team5cab.contollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.BookingService;
import sg.iss.team5cab.services.FacilityServices;
import sg.iss.team5cab.services.FacilityTypeService;

@Controller
public class BookingController {
	@Autowired
	BookingService bService;
	// @Autowired
	// FacilityService fService; //need facility service interface

	@RequestMapping(value = "admin/booking/create/{id}", method = RequestMethod.GET)
	public ModelAndView newBookingPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("booking-create-update");
		// mav.addObject("facility", fService.findFacility(id));
		mav.addObject("availableDateList", bService.findAvailableDates(id));
		return mav;
	}

	@RequestMapping(value = "admin/booking/create/{id}", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute Booking booking) {
		bService.createBooking(booking);
		return new ModelAndView("booking-confirmation", "booking", booking);
	}
	
	@Autowired
	FacilityTypeService ftService;
	

	
	@RequestMapping(value="/admin/booking/search",method=RequestMethod.GET)
	public ModelAndView createSearchPage()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("booking",new Booking());
		
		mav.addObject("listOfFacilityID",bService.findAllFacilityID());
		mav.setViewName("booking-search");
		return mav;
	}
	@RequestMapping(value="/admin/booking/search",method=RequestMethod.POST)
	public ModelAndView displaySearchResult(@ModelAttribute("booking") Booking booking)
	{
		ModelAndView mav=new ModelAndView();
		List<Booking> listBookings=bService.findBookingByAdmin(booking.getFacility().getFacilityID(), booking.getStartDate(), booking.getEndDate(), booking.getUsers().getUserID());//facilityID userID hardcoded
		mav.addObject("listOfBookings",listBookings);
		mav.setViewName("booking-search");
		return mav;
		}
	@RequestMapping(value="/admin/booking/edit/{bookingID}",method = RequestMethod.GET)
    public ModelAndView editBooking(@PathVariable int bookingID)
    {
		Booking booking  = bService.findBookingByID(bookingID);
		ModelAndView mav = new ModelAndView("booking-edit", "Booking", booking);
		
		return mav;
    }
	@RequestMapping(value="/admin/booking/edit/{bookingID}",method = RequestMethod.POST)
    public ModelAndView editBookingConfirmation(@ModelAttribute("booking") Booking book)
    {
    	ModelAndView mav =new ModelAndView("booking-confirmation", "booking", bService.updateBooking(book));
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
