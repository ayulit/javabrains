package org.koushik.javabrains.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koushik.javabrains.database.DatabaseClass;
import org.koushik.javabrains.model.Comment;
import org.koushik.javabrains.model.ErrorMessage;
import org.koushik.javabrains.model.Message;

public class CommentService {
	
	// stub for DB: using static class
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());				
	}
	
	public Comment getComment(long messageId, long commentId) {
		
		// preparing 'ErrorMessage' for a 'Response'
		ErrorMessage errorMessage = new ErrorMessage("Not found",
                404, 
                "http://www.google.com");

		// preparing 'Response' for a 'WebApplicationException'
		Response response = Response.status(Status.NOT_FOUND)
								    .entity(errorMessage)
							   	    .build();
		
		Message message = messages.get(messageId);
		
		// Throwing 'WebApplicationException' which is a JAX-RS's good friend :)
		if (message == null) {
			throw new WebApplicationException(response);
		}
			
		Map<Long, Comment> comments = message.getComments();
		Comment comment = comments.get(commentId);
		
		if (comment == null) {
			// Let's use specific Exception inherited from 'WebApplicationException'!
			throw new NotFoundException(response);
		}		
		
		return comment;
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);	
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		if (comment.getId() <= 0) {
			return null;
		}
		
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
