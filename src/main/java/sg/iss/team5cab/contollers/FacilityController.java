package sg.iss.team5cab.contollers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.model.FacilityType;
import sg.iss.team5cab.model.Users;
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
		System.out.println("printing faciliyt");
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
	public ModelAndView newFacilityPage(@ModelAttribute("Facility") Facility fac) {

		ModelAndView mav = new ModelAndView("facility_search");

		mav.addObject("Facility", fService.findFacility(null, null, null, false));
		mav.addObject("facilityType", ftService.findAllType());

		return mav;
	}
     
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView FacilitySearchPage(@ModelAttribute("Facility") Facility fac, BindingResult result,
			final RedirectAttributes redirectAttributes, @RequestParam("typeName") String typeName,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "MM-dd-yyyy") Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "MM-dd-yyyy") Date endDate,
			@RequestParam(value = "isDamaged", required = false) boolean isDamaged) {
    	System.out.println("Executing Search Controller.....");
		ModelAndView mav = new ModelAndView();
		String typeId = "";
		switch (typeName) {

		case "Meeting Room":
			typeId = "MR";
			break;
		case "Table Tennis":
			typeId = "TT";
			break;
		case "Swimming Pool":
			typeId = "SP";
			break;
		case "Basket Ball":
			typeId = "BB";
			break;
		case "Badminton":
			typeId = "BT";
			break;
		case "Football":
			typeId = "FB";
			break;
		case "Board games":
			typeId = "BG";
			break;
		default:
			;

		}
		mav.setViewName("facility_search");
		System.out.println("Before Search.....");
		mav.addObject("Facility", fService.findFacility(typeId, startDate, endDate, isDamaged));
		System.out.println("After Search.....");
		mav.addObject("typeNames", ftService.findAllType());

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
		 
		mav.setViewName("redirect:/search");
		mav.addObject("message",msg);
		return mav;

	}

}
