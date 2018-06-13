package sg.iss.team5cab.contollers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team5cab.model.Booking;
import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.FacilityType;
import sg.iss.team5cab.services.FacilityServices;
import sg.iss.team5cab.services.FacilityTypeService;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

	@Autowired
	private FacilityServices fService;

	@Autowired
	private FacilityTypeService ftService;	


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createFacilityPage() {
		ModelAndView mav = new ModelAndView("facility_create_update");		
		mav.addObject("Facility", new Facility());
		mav.addObject("listOfFacilityType",ftService.findAllType());
		mav.setViewName("facility_create_update");
		return mav;

	}
	
	@RequestMapping(value="/create", method =RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute("Facility") Facility facility, 
			final RedirectAttributes redirectAttributes)
	{
		ModelAndView mav=new ModelAndView();	
		//if(result.hasErrors())
		//return new ModelAndView("facility_create_update");		
		
		//String message="New Facility" + facility.getFacilityName() + "was sucessfully created";
		System.out.println("printing facility");
		System.out.println(facility.toString());
		fService.createFacility(facility);		
		mav.setViewName("redirect:/facility/create/confirmation");	
	    redirectAttributes.addFlashAttribute("facility", facility);
	     return mav;
	}
	
	@RequestMapping(value = "/create/confirmation", method = RequestMethod.GET)
	public ModelAndView createFacilityConfirmationPage(@ModelAttribute("Facility") Facility facility) {
		ModelAndView mav = new ModelAndView("facility-confirmation");
		mav.addObject("Facility", facility);
		
		return mav;
	}


		
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView newFacilityPage(@ModelAttribute("Booking") Booking book) {

		ModelAndView mav = new ModelAndView("facility_search");

		mav.addObject("Facility", fService.findFacility(null, null, null, false));
		mav.addObject("listOfFacilityType",ftService.findAll());

		return mav;
	}
     
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView FacilitySearchPage(@ModelAttribute("Booking") Booking book, BindingResult result,
			final RedirectAttributes redirectAttributes)
    		throws Exception{
    	
    	System.out.println("Executing Search Controller.....");
		ModelAndView mav = new ModelAndView();
		
		//SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");  
		System.out.println("YO");
		System.out.println(book.getFacility().getFacilityType());
		Facility f = book.getFacility();
		FacilityType ft = f.getFacilityType().getTypeID().equals("") ? null :f.getFacilityType();
		System.out.println(book.getFacility().getFacilityType());

		Date sDate=book.getStartDate();
		Date eDate=book.getEndDate();
		boolean isDmged = book.getFacility().getIsDamaged();

		System.out.println(sDate);
		System.out.println(eDate);
		
		
		mav.setViewName("facility_search");
		
		
		System.out.println("Before Search.....");
	
		mav.addObject("Facility", fService.findFacility(ft, sDate, eDate, isDmged));
		mav.addObject("listOfFacilityType",ftService.findAll());
		
		return mav;
	}


	@RequestMapping(value = "/update/{fid}", method = RequestMethod.GET)
	public ModelAndView updateFacilityPage(@PathVariable int fid, HttpServletRequest request) {
		Facility facility = fService.findFacilityById(fid);
		ModelAndView mav = new ModelAndView("facility_create_update","Facility",facility);
	
		return mav;
	
	}

	@RequestMapping(value = "/update/confirmation", method = RequestMethod.POST)
	public ModelAndView updateFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			@PathVariable int fid, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("facility-create-update");

		ModelAndView mav = new ModelAndView();
		// String message="Department was sucessfully updated";

		fService.updateFacility(facility);
		mav.setViewName("redirect:/facility-confirmation");
		redirectAttributes.addFlashAttribute("facility", facility);
		return mav;

	}


	@RequestMapping(value = "/delete/{fid}", method = RequestMethod.GET)
	public ModelAndView deleteFacilty(@PathVariable int fid) {
		ModelAndView mav = new ModelAndView();
		String msg;
		
		Facility facility = fService.findFacilityById(fid);
		boolean isDeleted =fService.deleteFacility(facility);
		
		 if(isDeleted) msg="The facility is deleted";
		 else msg="The facility is not deleted";
		 
		mav.setViewName("redirect:../search");
		return mav;
		
	}

}
