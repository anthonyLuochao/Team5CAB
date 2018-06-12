package sg.iss.team5cab.contollers;

import java.util.ArrayList;
import java.util.HashMap;

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
public class UsersController {

	//@Autowired
	@Autowired
	private UsersService uService;

	@RequestMapping(value="/admin/user/search", method = RequestMethod.GET)
	public ModelAndView displaySearchUser()
	{
		ArrayList<Users> users = uService.findAllUsers();
		ModelAndView mav = new ModelAndView("users_search","Users", users);
		mav.addObject("searchTerm", new Users());
		return mav;
	}
	
	@RequestMapping(value="/admin/user/search", method = RequestMethod.POST)
	public ModelAndView displaySearchUser(@ModelAttribute("searchTerm") Users user)
	{
		ArrayList<Users> users = uService.findUsersByIdOrName(user.getName(), user.getName());
		return new ModelAndView("users_search","Users", users);
	}	
	
	@RequestMapping(value="/adduser",method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Users users)
	{
		ModelAndView mav = new ModelAndView("userconfirmationpage","Users",new Users());
		uService.CreateUser(users);
		return mav;
	}
	
	@RequestMapping(value="/admin/user/edit/{userID}",method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable String userID)
    {
		Users user = uService.findUserByUID(userID);
		ModelAndView mav = new ModelAndView("users_edit", "User", user);
		mav.addObject("roleList", getRoles());
		return mav;
    }

	@RequestMapping(value="/admin/user/edit",method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("User") Users updatedUser)
    {
    	Users oldUser = uService.findUser(updatedUser.getUserID());
    	updatedUser.setPassword(oldUser.getPassword());
    	uService.changeUser(updatedUser);
    	return new ModelAndView("user-confirmation");
    }

	@RequestMapping(value="/admin/user/delete/{userid}",method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable("userid") String userid) 
    {
    	//String message = "User was successfully deleted.";
    	uService.removeUser(userid);
    	return new ModelAndView("redirect:/admin/user/search");
    }
	
	private ArrayList<String> getRoles() {
		ArrayList<String> roles = new ArrayList<String>();
		roles.add("Member");
		roles.add("Admin");
		return roles;
	}
}
