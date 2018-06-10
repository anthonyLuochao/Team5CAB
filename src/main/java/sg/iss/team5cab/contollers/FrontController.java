package sg.iss.team5cab.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView test() {
		return new ModelAndView("home");
	}
}
