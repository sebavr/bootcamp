package com.codingdojo.Dojo_Overflow.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.Dojo_Overflow.models.Answer;
import com.codingdojo.Dojo_Overflow.models.Question;
import com.codingdojo.Dojo_Overflow.services.QuestionService;

@Controller
public class OverflowController {
	private final QuestionService questionService;

	public OverflowController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	

@RequestMapping("/")
public String start() {
return "redirect:questions";
}	
	
@GetMapping("questions")
public String dashboard(Model model) {
	model.addAttribute("questions",questionService.allQuestions());
    return "dashboard.jsp";
}

@GetMapping("/questions/new")
public String newquestion(@ModelAttribute("sumar_question") Question question) {
return "newQuest.jsp";
}	

@PostMapping("/questions/new")
public String postquestion(@RequestParam("tagcito") String tags,@ModelAttribute("sumar_question") Question question,BindingResult result,RedirectAttributes err) {
	
	List<String> tagcadena=Arrays.asList(tags.split(","));//con esto se separa con comas
	
	if(tagcadena.size()>3) {
		String error="<div>No debe haber mas de 3 tags</div>"+tagcadena;
		err.addFlashAttribute("error", error);
		
		return "redirect:/questions/new";
	}else if(tags.length()==0) {
		String error="<div>Debe tener al menos 1 tag, Despailate</div>";
		err.addFlashAttribute("error", error);
		
		return "redirect:/questions/new";
	}
	if(result.hasErrors()) {
		
		return "newQuest.jsp";
	} 
	else {
		
		questionService.tags_quecontiene_question(tagcadena, question);
		//chequear si los tags estan y guardarlos
		//crear este metodo en el service
		
		
		return "redirect:/";
	}
}


@GetMapping("/questions/{questionId}")
public String questionProfile(@ModelAttribute("sumar_answer")Answer answer,@PathVariable("questionId")Long id,Model model) {
	model.addAttribute("question",questionService.findQuestion(id));
	return"questionProfile.jsp";
}

@PostMapping("/questions/{questionId}")
public String addAnswerToQuestion(@Valid @ModelAttribute("sumar_answer")Answer answer,BindingResult result,@PathVariable("questionId")Long id , Model model) {
	if(result.hasErrors()) {
		model.addAttribute("question",questionService.findQuestion(id));
		return"questionProfile.jsp";
	}
	else {
		
		answer.setQuestion(questionService.findQuestion(id));
		questionService.guardarAnswer(answer);
		return"redirect:/questions/"+id;
	}
}


}