package sg.iss.team5cab.contollers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.BookingService;
//import sg.iss.team5cab.services.FacilityService;
import sg.iss.team5cab.services.UsersService;

@Controller
public class BookingController {
	@Autowired
	BookingService bService;
	// @Autowired
	//FacilityService fService; //need facility service interface
	@Autowired
	UsersService uService;
	
	@RequestMapping(value = "admin/booking/create/{facilityID}", method = RequestMethod.GET)
	public ModelAndView newBookingPage(@PathVariable("facilityID") int facilityID, HttpSession session) {
		// get the user id from session scope
		//String userID = session.getAttribute("userID").toString();
		String userID = "Abraham1234";
		
		// Get both objects from their respective id
		Users user = uService.findUser(userID);
		//Facility facility = fService.findFacilityById(facilityID);
		Booking booking = new Booking();
		booking.setUsers(user);
		//booking.setFacility(facility);
		
		ModelAndView mav = new ModelAndView("booking-create-update", "booking", booking);
		//mav.addObject("facility", fService.findFacilityById(id));
		mav.addObject("availableDateList", bService.findAvailableDates(facilityID));
		return mav;
	}

	@RequestMapping(value = "admin/booking/create", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute("booking") Booking booking) {
		/*
		if(bService.isBookingClash(booking.getFacility().getFacilityID(), booking.getStartDate(), booking.getEndDate())){
			//some error feedback
			return new ModelAndView("booking-create-update", "booking", booking);
			}
		else{
			bService.createBooking(booking);
			return new ModelAndView("booking-confirmation", "booking", booking);
		} */
		return new ModelAndView("booking-confirmation", "booking", booking);
	}
	
	@Autowired
	//FacilityTypeService ftService;
	
	@RequestMapping(value="/admin/booking/search",method=RequestMethod.GET)
	public ModelAndView loadFacilityTypeToDropdownList()
	{
		ModelAndView mav=new ModelAndView();
		//fList<String> typeName=ftService.findAllType();
		//mav.addObject("listOfFacilityType",ftService.findAllType());
		mav.setViewName("booking-search");
		return mav;
	}
	

}
