package com.codingdojo.NinjaGold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication

public class NinjaGoldApplication {
//	Date dt = new Date();
//    String current_date = String.format("%s %tA, the %<te of %<tB, %<tY ", "Date:", dt);
	Random rand = new Random();	
	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index(Model model ,HttpSession session) {
	Date dt = new Date();
	if(session.getAttribute("gold")==null){
		ArrayList<String> log = new ArrayList<String>();	
		session.setAttribute("gold",0);
		String newlog = ("<p>Game started at 0 Gold on:" + dt.toString() +"</p>");
		log.add(0,newlog);
		session.setAttribute("log",log);
	}
	model.addAttribute("gold", session.getAttribute("gold"));
	model.addAttribute("log", session.getAttribute("log"));	
		return "index";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpSession session) {
	Date dt = new Date();
	if(session.getAttribute("gold")==null || session.getAttribute("log")==null ) {
		return "redirect:/";
	}
	int current_gold = (int) session.getAttribute("gold");
	int x = rand.nextInt(10) +10 ;
	ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
	current_gold += x;
		session.setAttribute("gold",current_gold);
	String newlog = ("<p class='green'>Went to the farm +"+x+" Gold is now: "+current_gold+" on: " + dt.toString() +"</p>");
		log.add(0, newlog);
		session.setAttribute("log",log);
	return "redirect:/";
	}
	@RequestMapping("/cave")
	public String cave(HttpSession session) {
	System.out.println("hit cave");
	Date dt = new Date();
	if(session.getAttribute("gold")==null || session.getAttribute("log")==null ) {
		return "redirect:/";
	}
	int current_gold = (int) session.getAttribute("gold");
	int x = rand.nextInt(5) +5 ;
	ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
	current_gold += x;
		session.setAttribute("gold",current_gold);
	String newlog = ("<p class='green'>Went to the cave +"+x+" Gold is now: "+current_gold+" on: " + dt.toString()+"</p>" );
		log.add(0,newlog);
		session.setAttribute("log",log);
	return "redirect:/";
	}
	@RequestMapping("/house")
	public String house(HttpSession session) {
	System.out.println("hit house");
	Date dt = new Date();
	if(session.getAttribute("gold")==null || session.getAttribute("log")==null ) {
		return "redirect:/";
	}
	int current_gold = (int) session.getAttribute("gold");
	int x = rand.nextInt(3) +2 ;
	ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
	current_gold += x;
		session.setAttribute("gold",current_gold);
	String newlog = ("<p class='green'> Went to the house +"+x+" Gold is now: "+current_gold+" on: " + dt.toString() +"</p>");
		log.add(0,newlog);
		session.setAttribute("log",log);
	return "redirect:/";
	}
	@RequestMapping("/casino")
	public String casino(HttpSession session) {
	System.out.println("hit casino");
	Date dt = new Date();
	String newlog ="";
	if(session.getAttribute("gold")==null || session.getAttribute("log")==null ) {
		return "redirect:/";}
	int current_gold = (int) session.getAttribute("gold");
	int x = rand.nextInt(100) -50 ;
	ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
	current_gold += x;
		session.setAttribute("gold",current_gold);
	if (x>0) {
		newlog = ("<p class='green'>Went to the casino +"+x+" Gold is now: "+current_gold+" on: " + dt.toString()+"</p>" );		
	}
	else {
		newlog = ("<p class='red'>Went to the casino "+x+" Gold is now: "+current_gold+" on: " + dt.toString() +"</p>");				
	}
		log.add(0,newlog);
		session.setAttribute("log",log);
	return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
}
