package com.project.doungen.controllers;

import com.project.doungen.models.User;
import com.project.doungen.repositories.UserRepository;
import com.project.doungen.services.UserService;
import com.project.doungen.validators.UserValidator;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController{
	private UserService userService;
	private UserValidator _uv;

	public UserController(UserService userService, UserValidator _uv){
		this.userService = userService;
		this._uv =_uv;

	}
	
	@RequestMapping("/")
	public String register(@ModelAttribute("user") User user, HttpSession s){
		s.setAttribute("id", null);
		return "register";
	}
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("user") User user, HttpSession s, Model model){
		User current = userService.findById((Long)s.getAttribute("id"));
		model.addAttribute("user", current);
		return "dashboard";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession s){
		s.setAttribute("id", null);
		return "redirect:/";
	}



	@PostMapping("/register")
	public String creater(@Valid @ModelAttribute("user") User user, BindingResult res, HttpSession session){
		_uv.validate(user, res);
		if(res.hasErrors()){
			return "register";
		}else{
			System.out.println("Your user is 0" + user);
			userService.create(user);
			session.setAttribute("id", user.getId());
			return "redirect:/dashboard";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password")String password, HttpSession session){
		User user = userService.findByEmail(email);
		
		if(user == null){
			User user2 = userService.findByUsername(email);
			if(user2 == null){
				return "redirect:/regiseter";
			}else{
				if( userService.isMatch(password, user2.getPassword()) ){
					session.setAttribute("id", user2.getId());
					return "redirect:/dashboard";

				}else{
					return "redirect:/";
				}
		}
	}else{
		if( userService.isMatch(password, user.getPassword()) ){
			session.setAttribute("id", user.getId());
			return "redirect:/dashboard";

		}else{
			return "redirect:/";
		}
 
	}
}
}
