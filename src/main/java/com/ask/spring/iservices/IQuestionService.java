package com.ask.spring.iservices;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.ask.spring.entities.Answer;
import com.ask.spring.entities.Comment;
import com.ask.spring.entities.Question;

public interface IQuestionService {
	
	public Question addQuestion(Question q);
	public Question updateQuestion(Question q,Long id);
	public void deleteQuestion(Long id);
	public List<Question> getQuestionByUser(Long iduser);
	public List<Question> getQuestionByTechnology(Long idtech);
	public List<Question> getQuestions();
	public Question getByid(Long id);
	public List<Answer> getAnswersByQuestion(Long idquestion);
	public List<Answer> getAnswersByUser(Long iduser);
	public List<Comment> getCommentsByAnswer(Long idanswer);
	public List<Comment> getCommentsByQuestion(Long idquestion);
	
	public Question addQuestionandAffecttouser(Question q, Long iduser,Long idtech);

	public Question addQuestionandAffecttouserq(Question q, Long iduser,Long idtech,Long idq);

}
