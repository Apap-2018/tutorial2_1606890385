package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PageController {
	@RequestMapping ("/viral")
	public String index()
	{
		return "viral";
	}
	
	@RequestMapping ("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge/", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	@RequestMapping ("/generator")
	public String generator(@RequestParam(value = "a", defaultValue="0",required = false) int a, @RequestParam(value="b", defaultValue="0",required= false) int b , @RequestParam(value="var", required = false, defaultValue = "hm") String var, Model model) {
		model.addAttribute("a",a);
		model.addAttribute("b", b);
		String hasil = "hm";
		String res ="";
		if(a>1) {
			System.out.println("a>1");
			for(int i=1;i<a;i++) {
				hasil+="m";
			}
			if(b>1) {
				System.out.println("masoook");
				for (int j=1;j<=b;j++) {
					res += hasil+" ";
				}
			}
			else {
				res = hasil;
			}
		}
		else if(b>1) {
			System.out.println("b>1");
			if(a<=1){
				for (int j=1;j<=b;j++) {
					res += hasil+" ";
				}
			}
		}
		else {
			res = hasil;
		}
		
		model.addAttribute("var", res);
		return "generator";
	}
}
	