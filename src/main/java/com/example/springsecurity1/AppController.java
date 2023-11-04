package com.example.springsecurity1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class AppController {

	@GetMapping("/welcome")
	public String sayWelcome()
	{
		return "welcome";
	}
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	@GetMapping("/manager")
	public String manager()
	{
		return "manager";
	}
	@GetMapping("/employee")
	public String emp()
	{
		return "emp";
	}
	@GetMapping("/common")
	public String common()
	{
		return "common";
	}
	@GetMapping("/ad")
	public String ad()
	{
		return "accessdenied";
	}
	@GetMapping("/mainapp")
	public String mainapp()
	{
		return "common";
	}
	@GetMapping("/sv")
	public String sv()
	{
		return "sv";
	}
	@GetMapping("/sa")
	public String sa()
	{
		return "sa";
	}
}
