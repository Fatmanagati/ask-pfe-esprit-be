package com.ask.spring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ask.spring.entities.Answer;
import com.ask.spring.services.AnswerService;
import com.ask.spring.services.QuestionService;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins="http://localhost:4200")
public class AnswerController {
	@Autowired
	AnswerService anserv;
	@Autowired
	QuestionService qserv;
	// http://localhost:8080/PFE/answer/add
	@PostMapping("/add")
	public Answer addAnswer(@RequestBody Answer a) {
		return anserv.addAnswer(a);
	}
	// http://localhost:8080/PFE/answer/addaff
	@PostMapping("/addaff/{id}/{idq}")
	public Answer addAnswer(@RequestBody Answer a, @PathVariable("id") Long id, @PathVariable("idq") Long idq) {
		return anserv.addandaffectuser(a, id, idq);
	}
	// http://localhost:8080/PFE/answer/update
	@PutMapping("/update/{id}")
	public Answer updateAnswer(@RequestBody Answer a, @PathVariable("id") Long id) {
		return anserv.updateAnswer(a, id);
	}
	// http://localhost:8080/PFE/answer/delete/{id}
	@DeleteMapping("/delete/{id}")
	public String deleteAnswer(@PathVariable("id") Long id) {
		anserv.deleteAnswer(id);
		return "réponse supprimé !";
	}
	// http://localhost:8080/PFE/answer/getbyquestion
	@GetMapping("/getbyquestion/{id}")
	public List<Answer> getAnswersByQuestion(@PathVariable("id") Long id) {
		return qserv.getAnswersByQuestion(id);
	}
	// http://localhost:8080/PFE/answer/getbyuser
	@GetMapping("/getbyuser/{id}")
	public List<Answer> getAnswersByUser(@PathVariable("id") Long id) {
		return qserv.getAnswersByUser(id);
	}
	// http://localhost:8080/PFE/answer/getbyid
	@GetMapping("/getbyid/{id}")
	public Answer getAnswerbyid(@PathVariable("id") Long id) {
		return anserv.getbyid(id);
	}
}
