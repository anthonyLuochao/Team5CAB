package sg.iss.team5cab.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.services.BookingService;
import sg.iss.team5cab.services.BookingServicesImpl;

@Controller
public class FrontController {
	
//	@Autowired
//	private BookingService bService;
//	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView test() {
//		System.out.println(bService.displayAll());
//		return new ModelAndView("home");
//}	
}
