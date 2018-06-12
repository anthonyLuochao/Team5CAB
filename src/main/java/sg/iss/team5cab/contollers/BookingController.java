import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.services.BookingService;

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
	public ModelAndView loadFacilityTypeToDropdownList()
	{
		ModelAndView mav=new ModelAndView();
		//fList<String> typeName=ftService.findAllType();
		mav.addObject("listOfFacilityType",ftService.findAllType());
		mav.setViewName("booking-search");
		return mav;
	}
	

}
