package com.project.doungen.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.project.doungen.models.Char;
import com.project.doungen.services.CharService;

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
public class CharController{
	//Member variables go here
	private CharService charService;

	public CharController(CharService charService){
		this.charService = charService;
	}

	@PostMapping("/buildChar")
	public String maker(@Valid @ModelAttribute("char") Char chare, BindingResult res, HttpSession session){
		if(res.hasErrors()){
			return "register";
		}else{
			charService.make(chare);
			return "redirect:/dashboard";
		}
	}
	@PostMapping("/stat")
	public String register(@Valid HttpSession s, BindingResult result){
		return "statAjax";
	}

}
