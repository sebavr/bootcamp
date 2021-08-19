package com.codingdojo.Dojo_Overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Dojo_Overflow.models.Answer;
import com.codingdojo.Dojo_Overflow.models.Question;
import com.codingdojo.Dojo_Overflow.models.Tag;
import com.codingdojo.Dojo_Overflow.models.TagQuestion;
import com.codingdojo.Dojo_Overflow.repositories.AnswerRepo;
import com.codingdojo.Dojo_Overflow.repositories.QuestionRepo;
import com.codingdojo.Dojo_Overflow.repositories.TagQuestionRepo;
import com.codingdojo.Dojo_Overflow.repositories.TagRepo;


@Service
public class QuestionService {
	
	private final QuestionRepo questionrepo;
	private final AnswerRepo answerrepo;
	private final TagRepo tagrepo;
	private final TagQuestionRepo tagquestrepo;


	public QuestionService(QuestionRepo questionrepo, AnswerRepo answerrepo, TagRepo tagrepo,
			TagQuestionRepo tagquestrepo) {
	
		this.questionrepo = questionrepo;
		this.answerrepo = answerrepo;
		this.tagrepo = tagrepo;
		this.tagquestrepo = tagquestrepo;
	}

	public List<Question> allQuestions() {
	        return questionrepo.findAll();
	    }

	 public Question guardarQuestion(Question p) {
	        return questionrepo.save(p);
	    }
	 
	 public Answer guardarAnswer(Answer a) {
		 return answerrepo.save(a);
	 }
	 
	//Obtener una catgoria por medio de su id

	    public Question findQuestion(Long id) {
	        Optional<Question> question = questionrepo.findById(id);
	        if(question.isPresent()) {
	            return question.get();
	        } else {
	            return null;
	        }
	    }

	 //eliminar una question
	    
	    public void deleteQuestion(Long id) {
	    	questionrepo.deleteById(id);
	    }
	    
	    public Tag guardarTag(Tag t) {
	    	return tagrepo.save(t);
	    }
	    
	    public Tag buscarTagPorNombre(String name) {
	    	return tagrepo.findBySubjectIgnoreCase(name);
	    	
	    }
	    
	    public TagQuestion guardarTagQuestion(TagQuestion tagQ) {
	    	return tagquestrepo.save(tagQ);
	    }
	    
	    //t serian los tags, q la question
	    public void tags_quecontiene_question(List<String> t,Question q) {
	    	Question guardarQuestion=guardarQuestion(q);
	    	for(String comprobar:t) {
	    		if(buscarTagPorNombre(comprobar)!=null) {
	    			TagQuestion unir=new TagQuestion();
	    			unir.setTag(buscarTagPorNombre(comprobar));
	    			unir.setQuestion(guardarQuestion);
	    			guardarTagQuestion(unir);
	    			
	    		}
	    		else {
	    			Tag nuevoTag=new Tag();
	    			nuevoTag.setSubject(comprobar);
	    			Tag tagg=guardarTag(nuevoTag);
	    			TagQuestion unir=new TagQuestion();
	    			unir.setTag(tagg);
	    			unir.setQuestion(guardarQuestion);
	    			guardarTagQuestion(unir);
	    		}
	    	}
	    }

}
