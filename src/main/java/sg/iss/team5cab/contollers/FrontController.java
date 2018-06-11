package sg.iss.team5cab.contollers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.services.BookingService;
import sg.iss.team5cab.services.BookingServicesImpl;

@Controller
public class FrontController {
	

	@RequestMapping(value= {"/", "public/welcome"}, method=RequestMethod.GET)
	public ModelAndView welcomeAnon(HttpSession session) {
		session.setAttribute("role", "anon");
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/admin/welcome", method=RequestMethod.GET)
	public ModelAndView welcomeAdmin(HttpSession session) {
		session.setAttribute("role", "admin");
		return new ModelAndView("welcome");
	}

	@RequestMapping(value="/member/welcome", method=RequestMethod.GET)
	public ModelAndView welcomeMember(HttpSession session) {
		session.setAttribute("role", "member");
		return new ModelAndView("welcome");
	}

}
