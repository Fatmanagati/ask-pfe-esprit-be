package com.ask.spring.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ask.spring.entities.Answer;
import com.ask.spring.entities.Comment;
import com.ask.spring.entities.Departement;
import com.ask.spring.entities.Question;
import com.ask.spring.entities.Technology;
import com.ask.spring.entities.User;
import com.ask.spring.iservices.IQuestionService;
import com.ask.spring.repositories.AnswerRepository;
import com.ask.spring.repositories.CommentRepository;
import com.ask.spring.repositories.DepartmentRepository;
import com.ask.spring.repositories.QuestionRepository;
import com.ask.spring.repositories.TechnologyRepository;
import com.ask.spring.repositories.UserRepository;

@Service
public class QuestionService implements IQuestionService {
	@Autowired
	QuestionRepository qrepo;
	@Autowired
	UserRepository userepo;
	@Autowired
	AnswerRepository ansrepo;
	@Autowired
	CommentRepository comrepo;
	@Autowired
	TechnologyRepository techrepo;
	@Autowired 
	DepartmentRepository deprepo;
	@Autowired
	EmailSenderService eService;
	@Override
	public Question addQuestion(Question q) {
		q.setDateQuestion(new Date());
		return qrepo.save(q);
	}
	@Override
	public Question updateQuestion(Question q, Long id) {
		Question qq = qrepo.findById(id).get();
		qq.setTitle(q.getTitle());
		qq.setText(q.getText());
		qq.setNbAnswers(q.getNbAnswers());
		qq.setDateQuestion(q.getDateQuestion());
		return qrepo.save(qq);
	}
	@Override
	public void deleteQuestion(Long id) {
		qrepo.deleteById(id);

	}
	@Override
	public List<Question> getQuestionByUser(Long iduser) {
		User u = userepo.findById(iduser).get();
		return u.getQuestions();
	}
	@Override
	public List<Question> getQuestions() {
		return (List<Question>) qrepo.findAll();
	}

	@Override
	public List<Answer> getAnswersByQuestion(Long idquestion) {
		Question q = qrepo.findById(idquestion).get();
		return q.getAnswers();
	}

	@Override
	public List<Comment> getCommentsByAnswer(Long idanswer) {
		Answer a= ansrepo.findById(idanswer).get();
		return a.getComments();
	}

	@Override
	public List<Comment> getCommentsByQuestion(Long idquestion) {
		Question q = qrepo.findById(idquestion).get();
		return q.getComments();
	}

	@Override
	public Question addQuestionandAffecttouser(Question q, Long iduser, Long idtech) {
		Technology t = techrepo.findById(idtech).get();
		User u = userepo.findById(iduser).get();
		q.setUser(u);
		q.setTechnology(t);
		u.questions.add(q);
		t.questions.add(q);
		return qrepo.save(q);
	}
	@Override
	public List<Question> getQuestionByTechnology(Long idtech) {
		Technology t=techrepo.findById(idtech).get();
		return t.getQuestions();
	}
	@Override
	public List<Answer> getAnswersByUser(Long iduser) {
		User u = userepo.findById(iduser).get();
		return u.getAnswers();
	}
	@Override
	public Question getByid(Long id) {
		Question q =qrepo.findById(id).get();
		
		q.setNbAnswers((long) q.getAnswers().size());
		return qrepo.findById(id).get();
	}
	@Override
	public Question addQuestionandAffecttouserq(Question q, Long iduser, Long idtech, Long idq) {
		Technology t = techrepo.findById(idtech).get();
		User u = userepo.findById(iduser).get();
		Departement d = deprepo.findById(idq).get();		
		q.setUser(u);
		q.setTechnology(t);
		q.setDepartement(d);
		u.questions.add(q);
		t.questions.add(q);
		d.questions.add(q);
		List<User> lu=d.users;
		for (int i = 0; i < lu.size(); i++) {
			eService.sendSimpleEmail(lu.get(i).getEmail(), "*** Welcome to AskApplication ***  \n" + "Your recieve a question from your colleague "+u.getUsername() +"please check your notifications ! "
					, "Welcome to AskApplication");
			
		}
		return qrepo.save(q);
	}

}
