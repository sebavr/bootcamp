package com.codingdojo.elcodigo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodigoController {
	@RequestMapping("/")
		public String home() {
		return "index.jsp";
	}
	
	
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
    public String login(@RequestParam(value="code") String code,RedirectAttributes redirectAttributes) {
	if(code.equals("bushido")) {
		return "code.jsp";
	}else {
		redirectAttributes.addFlashAttribute("error", "Debes entrenar, más duro");
		
		
	}
	return "redirect:/";
	}
}

	/*@RequestMapping("/error")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "A test errror!");
        return "redirect:/";
	}*/

	


	/*@RequestMapping("redirect:/")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "A test errror!");
        return "redirect:/";
	}*/

