package com.ask.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Answer;
import com.ask.spring.entities.Comment;
import com.ask.spring.entities.Question;
import com.ask.spring.entities.User;
import com.ask.spring.iservices.ICommentService;
import com.ask.spring.repositories.AnswerRepository;
import com.ask.spring.repositories.CommentRepository;
import com.ask.spring.repositories.QuestionRepository;
import com.ask.spring.repositories.UserRepository;

@Service
public class CommentService implements ICommentService{

	@Autowired 
	CommentRepository comrepo;
	
	@Autowired 
	UserRepository userepo;
	
	@Autowired
	QuestionRepository qrepo;
	
	@Autowired
	AnswerRepository arepo;
	
	@Override
	public Comment addComment(Comment c) {
		// TODO Auto-generated method stub
		return comrepo.save(c);
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		comrepo.deleteById(id);
		
	}

	@Override
	public Comment addCommenttoquestion(Comment c, Long idq, Long idu) {
		User u = userepo.findById(idu).get();
		Question q= qrepo.findById(idq).get();
		u.comments.add(c);
		q.comments.add(c);
		c.setUser(u);
		c.setQuestion(q);
		return comrepo.save(c);
	}

	@Override
	public Comment addCommenttoanswer(Comment c, Long ida, Long idu) {
		User u = userepo.findById(idu).get();
		Answer a= arepo.findById(ida).get();
		u.comments.add(c);
		a.comments.add(c);
		c.setUser(u);
		c.setAnswer(a);
		return comrepo.save(c);
	}

}
