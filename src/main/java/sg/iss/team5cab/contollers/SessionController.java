package sg.iss.team5cab.contollers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Users;

@Controller
public class SessionController {
	
	// TODO:Add in Autowired for UsersService
	// @Autowired
	// UsersService usersService;

	@RequestMapping(value="public/login", method=RequestMethod.GET)
	public ModelAndView loadLogin(HttpSession session) {
		return new ModelAndView("user_login", "Users", new Users());
	}
	
	@RequestMapping(value="public/login", method=RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("Users") Users user, HttpSession session) {
		// TODO: Change following if statement to UsersServices password query
		// Users authUser = usersService
		// if (authUser != null) {
		if (user.getUserID().equals("test") && user.getPassword().equals("123")) {
			// TODO: Set attribute based on user
			// session.setAttribute("role", user.getRole);
			session.setAttribute("role", "admin");
			return new ModelAndView("welcome");
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
