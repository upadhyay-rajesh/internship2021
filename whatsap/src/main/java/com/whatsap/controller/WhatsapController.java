package com.whatsap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.whatsap.entity.WhatsappUser;
import com.whatsap.service.WhatsappServiceInterface;

@Controller
public class WhatsapController {
	//step 4
	@Autowired  //here it will create object of class which will use WhatsappServiceInterface automatically
	private WhatsappServiceInterface ws;
	
	@RequestMapping("/")
	public ModelAndView display() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping("createprofile")
	public ModelAndView create(@RequestParam("name") String name,@RequestParam("pass") String password,@RequestParam("email") String email,@RequestParam("address") String address) {
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		
		int i=ws.createProfileService(wu);
		
		String rr="registration fail";
		
		if(i>0) {
			rr="registration Success";
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", rr);
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView loginuser(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		WhatsappUser wu=new WhatsappUser();
		wu.setPassword(password);
		wu.setEmail(email);
		
		
		boolean i=ws.loginProfileService(wu);
		
		String rr="login fail";
		
		ModelAndView mv=new ModelAndView();
		
		if(i) {
			rr="Welcome "+email;
			mv.addObject("result", rr);
			mv.setViewName("home_page.jsp");
		}
		else {
		mv.addObject("result", rr);
		mv.setViewName("index.jsp");
		}
		return mv;
	}
	//step 1
	@RequestMapping("viewprofile")
	public ModelAndView viewuser(/*step 2*/@RequestParam("email") String email) {
		
		//step 3
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
				
		WhatsappUser i=ws.viewProfileService(wu); //step 5
		
		String rr="profile not found";
		
		ModelAndView mv=new ModelAndView();
		
		if(i!=null) {
			rr="profile data is below ";
			mv.addObject("result1", "Name is -->"+i.getName());
			mv.addObject("result2", "Password is -->"+i.getPassword());
			mv.addObject("result3", "Email is -->"+i.getEmail());
			mv.addObject("result4", "Address is -->"+i.getAddress());
			mv.addObject("result", rr);
			mv.setViewName("home_page.jsp");
		}
		else {
		mv.addObject("result", rr);
		mv.setViewName("home_page.jsp");
		}
		return mv;
	}

}
