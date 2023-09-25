package com.ask.spring.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Answer;
import com.ask.spring.entities.Question;
import com.ask.spring.entities.User;
import com.ask.spring.iservices.IAnswerService;
import com.ask.spring.repositories.AnswerRepository;
import com.ask.spring.repositories.QuestionRepository;
import com.ask.spring.repositories.UserRepository;

@Service
public class AnswerService implements IAnswerService {

	@Autowired
	AnswerRepository ansrepo;
	
	@Autowired 
	UserRepository userepo;
	
	@Autowired 
	QuestionRepository qrepo;
	
	@Autowired
	EmailSenderService eService;
	
	@Override
	public Answer addAnswer(Answer a) {
		a.setDateAswer(new Date());
		return ansrepo.save(a);
	}

	@Override
	public Answer updateAnswer(Answer a,Long id) {
		// TODO Auto-generated method stub
		Answer aa=ansrepo.findById(id).get();
		aa.setDateAswer(a.getDateAswer());
		aa.setResolved(a.isResolved());
		aa.setText(a.getText());
		return ansrepo.save(aa);
	}

	@Override
	public void deleteAnswer(Long id) {
		// TODO Auto-generated method stub
		ansrepo.deleteById(id);
		
	}

	@Override
	public Answer addandaffectuser(Answer a, Long iduser,Long idq) {
		User u= userepo.findById(iduser).get();
		Question q=qrepo.findById(idq).get();
		u.answers.add(a);
		q.answers.add(a);
		a.setUser(u);
		a.setQuestion(q);
		eService.sendSimpleEmail(q.getUser().getEmail(), "*** Welcome to AskApplication ***  \n" + "Your colleague "+u.getUsername() +" answered you please check your notifications maybe it could help you ! "
				, "Welcome to AskApplication");
		return ansrepo.save(a);
	}

	@Override
	public Answer getbyid(Long id) {
		return ansrepo.findById(id).get();
	}

}
