package com.ask.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ask.spring.entities.Comment;
import com.ask.spring.iservices.ICommentService;
import com.ask.spring.services.QuestionService;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins="http://localhost:4200")
public class CommentController {
	@Autowired
	ICommentService comserv;
	@Autowired
	QuestionService qserv;
	// http://localhost:8080/PFE/comment/add
	@PostMapping("/add")
	public Comment addComment(@RequestBody Comment c) {
		return comserv.addComment(c);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteComment(@PathVariable Long id) {
		comserv.deleteComment(id);
		return "commentaire supprimé!";
	}
	@PostMapping("/addaffectq/{idq}/{idu}")
	public Comment addCommentquestion(@RequestBody Comment c, @PathVariable("idq") Long idq,
			@PathVariable("idu") Long idu) {
		return comserv.addCommenttoquestion(c, idq, idu);
	}
	@PostMapping("/addaffecta/{ida}/{idu}")
	public Comment addCommentanswer(@RequestBody Comment c, @PathVariable("ida") Long ida,
			@PathVariable("idu") Long idu) {
		return comserv.addCommenttoanswer(c, ida, idu);
	}
	// http://localhost:8080/PFE/comment/getbyanswer
	@GetMapping("/getbyanswer/{id}")
	public List<Comment> getbyAnswers(@PathVariable("id") Long id) {
		return qserv.getCommentsByAnswer(id);
	}
	// http://localhost:8080/PFE/comment/getbyquestion
	@GetMapping("/getbyquestion/{id}")
	public List<Comment> getbyQuestions(@PathVariable("id") Long id) {
		return qserv.getCommentsByQuestion(id);
	}
}
