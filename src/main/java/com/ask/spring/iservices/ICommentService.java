package com.ask.spring.iservices;

import com.ask.spring.entities.Comment;

public interface ICommentService {

	public Comment addComment(Comment c);
	public void deleteComment(Long id);
	public Comment addCommenttoquestion(Comment c , Long idq,Long u);
	public Comment addCommenttoanswer(Comment c , Long ida, Long u);
}
