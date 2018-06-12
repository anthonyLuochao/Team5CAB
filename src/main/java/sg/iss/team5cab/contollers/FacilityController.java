package sg.iss.team5cab.contollers;

import java.util.ArrayList;

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

import sg.iss.team5cab.model.Facility;
import sg.iss.team5cab.services.FacilityServices;

@Controller
@RequestMapping(value="/facility")

public class FacilityController {

@Autowired
private FacilityServices fService;

@RequestMapping(value="/facility-create-update", method =RequestMethod.GET)
public ModelAndView newFacilityPage()
{
	ModelAndView mav=new ModelAndView("facility-search","facility", new Facility());
	mav.addObject("facilitylist", fService.findAllFacilities());
	return mav;
			
}

@RequestMapping(value="/facility-create-update", method =RequestMethod.POST)
public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
		final RedirectAttributes redirectAttributes)
{
	if(result.hasErrors())
	return new ModelAndView("facility-create-update");
	
	ModelAndView mav=new ModelAndView();
	//String message="New Facility" + facility.getFacilityName() + "was sucessfully created";

	fService.createFacility(facility);
	mav.setViewName("redirect:/facility-confirmation");	
    redirectAttributes.addFlashAttribute("facility", facility);
     return mav;
			
}

   @RequestMapping(value= "/facility-search",method=RequestMethod.GET)
   public ModelAndView facilitySearchPage() {
	   ModelAndView mav=new ModelAndView("facility-search");
	   ArrayList<Facility> facilityList=fService.findAllFacilities();
	   mav.addObject("facilityList", facilityList);
	   return mav;
   }
   
   @RequestMapping(value="/facility-create-update",method=RequestMethod.GET)
   public ModelAndView updateFacilityPage(@PathVariable int fid) {
     ModelAndView mav=new ModelAndView("facility-create-update") ;      
	 Facility facility = fService.findFacility(fid);
	 mav.addObject("facility",facility);
	 mav.addObject("fidlist", fService.findAllFacilities());
	 return mav;	 
	 
   }
   
 @RequestMapping(value="/facility-create-update/",method=RequestMethod.POST)
 public ModelAndView updateFacility(@ModelAttribute @Valid Facility facility,BindingResult result,
		 @PathVariable int fid,final RedirectAttributes redirectAttributes) {
	 
	 if(result.hasErrors())
		 return new ModelAndView("facility-create-update");
	 
	 ModelAndView mav=new ModelAndView();
	// String message="Department was sucessfully updated";
	 
	   fService.updateFacility(facility);	 
		mav.setViewName("redirect:/facility-confirmation");	
	    redirectAttributes.addFlashAttribute("facility", facility);
	     return mav;    
	 	
 }

@RequestMapping(value="/facility-search",method=RequestMethod.GET)
public boolean deleteFacilty(@PathVariable int fid) {
	ModelAndView mav=new ModelAndView();
	Facility facility=fService.findFacility(fid);
	return fService.deleteFacility(facility);	


}

}
