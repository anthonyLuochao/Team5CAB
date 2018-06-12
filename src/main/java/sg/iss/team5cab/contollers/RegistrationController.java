package sg.iss.team5cab.contollers;

import java.awt.Component;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Users;
@Controller
public class RegistrationController extends HttpServlet
{
	private static final Component frame = null;
	// TODO:Add in Autowired for UsersService
	//@Autowired
    // UsersService usersService;
	
	@RequestMapping(value="public/register", method = RequestMethod.GET)
	public ModelAndView displayRegistration(HttpSession session) {
		return new ModelAndView("user_registration", "Users", new Users());
	}
	
	@RequestMapping(value="public/register", method = RequestMethod.POST)
	public ModelAndView processRegistration(@ModelAttribute("Users") Users user, HttpSession session) 
	{
		
		System.out.println(user.getAddress());
		//Users authUser = usersService;
		//user.findUserByUID(user.getUserID());
		//if(user!=null) 
		if(user.getUserID().equals("G123"))
		{
			JOptionPane.showMessageDialog(frame, "the one you registered has already existed.");
			
			return new ModelAndView("user_registration", "Users", user);
		}
		else 
		{
			//user.CreateUser();
			JOptionPane.showMessageDialog(frame, "registered successfully.");
			ModelAndView mav = new ModelAndView("user_login");
			return mav;
		}
	}
}