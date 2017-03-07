package org.koushik.javabrains.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON) // to convert input JSON to Message 
@Produces(MediaType.APPLICATION_JSON) // annotating class allows us not to annot methods
public class MessageResource {
		
	MessageService messageService = new MessageService();
	
	@GET	
	public List<Message> getMessages(@QueryParam("year") int year, 
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		
		/* we need to convert List to XML using JAXB */		
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")	
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
		
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id); // we need to do it here
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}


}
