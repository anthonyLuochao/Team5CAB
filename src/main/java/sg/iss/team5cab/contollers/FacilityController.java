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

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

	@Autowired
	private FacilityServices fService;

	private ArrayList<String>getTypeNames(){
		
		return new ArrayList<String>();
	}
	



	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createFacilityPage() {
		ModelAndView mav = new ModelAndView("facility_create_update");
		mav.addObject("fType", getFacilityType());
		mav.addObject("Facility", new Facility());
		System.out.println("inside create load");
		return mav;

	}
	
	@RequestMapping(value="/create", method =RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute("Facility") Facility facility, 
			final RedirectAttributes redirectAttributes)
	{
		
		System.out.println("inside create load");
		System.out.println(facility.toString());
	
	
		//if(result.hasErrors())
		//return new ModelAndView("facility_create_update");
		
		ModelAndView mav=new ModelAndView();
		//String message="New Facility" + facility.getFacilityName() + "was sucessfully created";
		System.out.println("inside create load");
		
	try {
		fService.createFacility(facility);
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		mav.setViewName("redirect:/facility/create/confirmation");	
	    redirectAttributes.addFlashAttribute("facility", facility);
	     return mav;
	}

	private ArrayList<FacilityType> getFacilityType() {

		ArrayList<FacilityType> fType = new ArrayList<FacilityType>();

		FacilityType fT = new FacilityType();
		fT.setTypeID("FB");
		fT.setTypeName("FootBall");
		fType.add(fT);
		

		// fType.add("TT");
		// fType.add("FB");

		return fType;
	}

		
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView newFacilityPage(@ModelAttribute("Facility") Facility fac) {

		ModelAndView mav = new ModelAndView("facility_search");

		mav.addObject("Facility", fService.findFacility(null, null, null, false));
		mav.addObject("facilityType", getFacilityType());

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
		mav.addObject("typeNames", getTypeNames());

		return mav;
	}

	@RequestMapping(value = "/create/confirmation", method = RequestMethod.GET)
	public ModelAndView createFacilityConfirmationPage(@ModelAttribute("Facility") Facility facility) {
		ModelAndView mav = new ModelAndView("facility-confirmation");
		mav.addObject("Facility", facility);
		System.out.println("inside create load");
		return mav;

	}
	// @RequestMapping(value= "/searchuser",method=RequestMethod.GET)
	// public ModelAndView facilitySearchPage() {
	// ModelAndView mav=new ModelAndView("facility_search");
	// ArrayList<Facility> facilityList=fService.findFacility();
	// mav.addObject("Facility", facilityList);
	// return mav;
	// }
	//
	// @RequestMapping(value="/update",method=RequestMethod.GET)
	// public ModelAndView updateFacilityPage(@PathVariable int fid) {
	// ModelAndView mav=new ModelAndView("facility-create-update") ;
	// Facility facility = fService.findFacilityById(fid);
	// mav.addObject("facility",facility);
	// mav.addObject("fidlist", fService.findAllFacilities());
	// return mav;
	//
	// }

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



//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
//			final RedirectAttributes redirectAttributes) {
//		if (result.hasErrors())
//			return new ModelAndView("facility_create_update");
//
//		ModelAndView mav = new ModelAndView();
//		// String message="New Facility" + facility.getFacilityName() + "was sucessfully
//		// created";
//
//		fService.createFacility(facility);
//		mav.setViewName("redirect:/facility-confirmation");
//		redirectAttributes.addFlashAttribute("facility", facility);
//		return mav;
//
//	}
//
	@RequestMapping(value = "/update/{fid}", method = RequestMethod.GET)
	public ModelAndView updateFacilityPage(@PathVariable int fid, HttpServletRequest request) {
		Facility facility = fService.findFacilityById(fid);
		ModelAndView mav = new ModelAndView("facility_create_update","Facility",facility);
		return mav;

	}

	@RequestMapping(value = "/facility//{fid}", method = RequestMethod.GET)
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
