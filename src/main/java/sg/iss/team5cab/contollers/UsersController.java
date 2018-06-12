package sg.iss.team5cab.contollers;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5cab.model.Users;
import sg.iss.team5cab.services.UsersService;

@Controller
@RequestMapping(value="/home")
 public class UsersController {

	//@Autowired
	@Autowired
	private UsersService uService;
	@RequestMapping(value="/adduser",method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Users users)
	{
		ModelAndView mav = new ModelAndView("userconfirmationpage","Users",new Users());
		
		uService.CreateUser(users);
		//String message = "User was successfully created.";
		
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
	
	
}
