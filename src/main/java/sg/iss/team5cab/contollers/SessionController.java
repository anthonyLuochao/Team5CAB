package sg.iss.team5cab.contollers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.UsersService;

@Controller
public class SessionController {
	
	@Autowired
	UsersService usersService;

	@RequestMapping(value="public/login", method=RequestMethod.GET)
	public ModelAndView loadLogin(HttpSession session) {
		return new ModelAndView("user_login", "Users", new Users());
	}
	
	@RequestMapping(value="public/login", method=RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("Users") Users user, HttpSession session) {
		Users authUser = usersService.authenticate(user.getUserID(), user.getPassword());
		if (authUser != null) {
			session.setAttribute("role", authUser.getRole().toLowerCase());
			session.setAttribute("userID", authUser.getUserID());
			return new ModelAndView("redirect:/welcome");
		}
		else {
			session.setAttribute("login", "false");
			return new ModelAndView("user_login", "Users", new Users());
		}
	}
	
	@RequestMapping(value="public/logout", method=RequestMethod.GET)
	public ModelAndView loadLogout(HttpSession session) {
		session.setAttribute("role",  null);
		return new ModelAndView("user_logout");
	}
}
