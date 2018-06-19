package com.oyr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("username") String username, @RequestParam("password") String password){
		System.out.println("my is login");
		return "username："+ username + "，password：" + password;
	}
	
}
