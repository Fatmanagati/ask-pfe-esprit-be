package com.ask.spring.iservices;

import com.ask.spring.entities.Answer;

public interface IAnswerService {

	public Answer addAnswer(Answer a);
	public Answer updateAnswer(Answer a,Long id);
	public void deleteAnswer(Long id);
	public Answer addandaffectuser(Answer a, Long iduser, Long idq);
	public Answer getbyid(Long id);
}
