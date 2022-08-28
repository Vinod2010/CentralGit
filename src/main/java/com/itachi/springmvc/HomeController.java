package com.itachi.springmvc;

import java.util.Arrays;

//import com.itachi.springmvc.dao.AlienDao;
import com.itachi.springmvc.model.Alien;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	//@Autowired
	//AlienDao dao;
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name", "Aliens");
	}
	
	@RequestMapping("/")
	public String home()
	{
		//System.out.println("Home page requested");
		return "index.jsp";
	}
	 
	/*@GetMapping("addAliens")
	public String requestAliens(Model m)
	{
		//List<Alien> aliens = Arrays.asList(new Alien(10,"naruto"),new Alien(20,"jiraya"));
		
		m.addAttribute("aliensDetails", dao.getAllAlien());
		return "aliens.jsp";
	}*/
	
	/*@RequestMapping("add")
	public String sum(HttpServletRequest req)
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int num3 = i + j;
		HttpSession session = req.getSession();
		session.setAttribute("num3", num3);
		return "result.jsp";
	}*/
	
	/*@RequestMapping("add")
	public String sum(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session)
	{
		int num3 = i + j;
		session.setAttribute("num3", num3);
		return "result.jsp";
	}*/
	
	/*@RequestMapping("add")
	public ModelAndView sum(@RequestParam("num1") int i, @RequestParam("num2") int j)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int num3 = i + j;
		mv.addObject("num3", num3);
		
		return mv;
	}*/
	
	@RequestMapping("add")
	public String sum(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) // here we can use ModelMap also and only difference is 
	{                                                                                    // if we have ordinary object as data then go for Model and if we map as data then go for ModelMap 
		int num3 = i + j;
		m.addAttribute("num3", num3);
		
		return "result.jsp";
	}
	
	/*@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, Model m)//here Model is an interface which used to store model attribute
	{
		Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		m.addAttribute("alien", a);
		return "alienResult.jsp";
	}*/
	
	/*@RequestMapping(value="addAlien" , method=RequestMethod.POST)
	public String addAlien(@ModelAttribute("alien") Alien a)
	{
		return "alienResult.jsp";
	}*/
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute("alien") Alien a)
	{
		return "alienResult.jsp";
	}
	
}
