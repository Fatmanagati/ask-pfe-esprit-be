package com.ask.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ask.spring.entities.Question;
import com.ask.spring.services.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins="http://localhost:4200")
public class QuestionController {

	@Autowired
	QuestionService queserv;

	// http://localhost:8080/PFE/question/add
	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question q) {
		return queserv.addQuestion(q);
	}

	// http://localhost:8080/PFE/question/addaff/{iduser}/{idtech}
	@PostMapping("/addaff/{idu}/{idt}")
	public Question addandaffectQuestion(@RequestBody Question q, @PathVariable("idu") Long idu,
			@PathVariable("idt") Long idt) {
		return queserv.addQuestionandAffecttouser(q, idu, idt);
	}

	// http://localhost:8080/PFE/question/addaffq/{iduser}/{idtech}
	@PostMapping("/addaffq/{idu}/{idt}/{idq}")
	public Question addandaffectQuestionuser(@RequestBody Question q, @PathVariable("idu") Long idu,
			@PathVariable("idt") Long idt, @PathVariable("idq") Long idq) {
		return queserv.addQuestionandAffecttouserq(q, idu, idt, idq);
	}
	// http://localhost:8080/PFE/question/delete/{id}
	@DeleteMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable("id") Long id) {
		queserv.deleteQuestion(id);
		return "question supprimé!";
	}

	// http://localhost:8080/PFE/question/update
	@PutMapping("/update/{id}")
	public Question updateQuestion(@RequestBody Question q, @PathVariable("id") Long id) {
		return queserv.updateQuestion(q, id);
	}

	// http://localhost:8080/PFE/question/getbyuser
	@GetMapping("/getbyuser/{id}")
	public List<Question> getQuestionbyuser(@PathVariable("id") Long id) {
		return queserv.getQuestionByUser(id);
	}

	// http://localhost:8080/PFE/question/getall
	@GetMapping("/getall")
	public List<Question> getQuestions() {
		return queserv.getQuestions();
	}

	// http://localhost:8080/PFE/question/getbytech
	@GetMapping("/getbytech/{id}")
	public List<Question> getQuestionbyTechnology(@PathVariable("id") Long id) {
		return queserv.getQuestionByTechnology(id);
	}

	// http://localhost:8080/PFE/question/getbyid
		@GetMapping("/getbyid/{id}")
		public Question getQuestionbyid(@PathVariable("id") Long id) {
			return queserv.getByid(id);
		}
}
