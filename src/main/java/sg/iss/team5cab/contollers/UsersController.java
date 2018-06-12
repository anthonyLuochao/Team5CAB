package sg.iss.team5cab.contollers;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.UsersService;

@Controller
//@RequestMapping(value="/home")
 public class UsersController extends HttpServlet{

	@Autowired
	private UsersService uService;
	
	@RequestMapping(value="/admin/users_create",method = RequestMethod.GET)
	public ModelAndView Usercreateview(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("users_create","Users",new Users());
		mav.addObject("roleList", getRoles());
		return mav;
	}
	
	@RequestMapping(value="/admin/users_create",method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("Users") Users users, HttpSession session,RedirectAttributes redirectAttributes)
	{
        //users.setPassword("12345");
		users.setPassword(uService.RandomPassword());
		Users user = uService.CreateUser(users);
		
		ModelAndView mav = new ModelAndView("user-confirmation","Users",user);
		//String message = "User was successfully created.";	
		//redirectAttributes.addFlashAttribute("Users",users);
		return mav;
	}
	@RequestMapping(value="/admin/users_create/confirmation",method = RequestMethod.GET)
	public ModelAndView confirmation(@ModelAttribute("Users")Users users,HttpSession session)
	{
		ModelAndView mav = new ModelAndView("user-confirmation","Users",new Users());
//		usersinfo.addAllAttributes((Collection<?>) users);
		return mav;
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value="searchUser", method = RequestMethod.GET)
	public ModelAndView selectUser (@PathVariable String userid)
	{
		ModelAndView mav = new ModelAndView("searchUser","Users",new Users());
		Users users = uService.findUserByUID(userid);
		
		return mav;
	}
	@RequestMapping(value="/edituser",method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute Users users)
    {
    	ModelAndView mav = new ModelAndView("userconfirmationpage","Users",new Users());    	
    	uService.changeUser(users);
    	//String message = "User was successfully updated.";
    	return mav;
    }
	@RequestMapping(value="/searchuser",method = RequestMethod.POST)
	  public ModelAndView SearchUser(@PathVariable String userid)
	    {
	    	ModelAndView mav = new ModelAndView("searchUser","Users",new Users());
	    	uService.findAllUsers();	  
	    	return mav;
	    }
	@RequestMapping(value="/removeuser",method = RequestMethod.GET)
    public void removeUser(@PathVariable String userid) 
    {
    	ModelAndView mav = new ModelAndView("/removeuser","Users",new Users());
    	Users users = uService.findUserByUID(userid);
    	//String message = "User was successfully deleted.";
    	uService.removeUser(userid);
    }
	
	private ArrayList<String> getRoles() {
		ArrayList<String> roles = new ArrayList<String>();
		roles.add("Member");
		roles.add("Admin");
		return roles;
	}
}
