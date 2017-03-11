package org.koushik.javabrains.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.resources.beans.MessageFilterBean;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON) // to convert input JSON to Message 
@Produces(MediaType.APPLICATION_JSON) // annotating class allows us not to annot methods
public class MessageResource {
		
	MessageService messageService = new MessageService();
	
	@GET	
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		/* we need to convert List to XML using JAXB */		
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")	
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		
		Message message = messageService.getMessage(id);
		
		// HATEOAS: fill links
		message.getLinks().clear(); // TODO: adding only if List doesn't contain this 'link'!
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");		
		message.addLink(getUriForComments(uriInfo, message), "comments"); // tricky
		
		// resource won't catch the exception and it goes to JAX-RS
		return message;
		
	}

	/* Construct complete 'uri' for all COMMENTS for use in getMessage() API */
	private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()        //  http://localhost:8080/messenger/webapi
		         .path(MessageResource.class)        //    /messages
		         .path(MessageResource.class,  // (here we go with a TRICK!)
		        	   "getCommentResource")         //      /{messageId}/comments
		         .path(CommentResource.class)        //         / --OPTIONAL slash!
		         .resolveTemplate("messageId", // (replacing {messageId} with its actual value!)
		        		          message.getId())   
		         .build();

		return uri.toString();
	}

	/* Construct complete 'uri' for 'profile' for use in getMessage() API */
	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()                  //  http://localhost:8080/messenger/webapi
				         .path(ProfileResource.class)          //    /profiles
				         .path(message.getAuthor())            //      /{authorName}
				         .build();
		
		return uri.toString();
	}

	/* Construct complete 'uri' for 'message' for use in getMessage() API */
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		
		String uri = uriInfo.getBaseUriBuilder()                  //  http://localhost:8080/messenger/webapi
		                    .path(MessageResource.class)           //    /messages
		                    .path(Long.toString(message.getId()))  //      /{messageId}
		                    .build()
		                    .toString();
		return uri;
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
				
		Message newMessage = messageService.addMessage(message); 
		String newId = String.valueOf(newMessage.getId());
		
		// we will use getAbsolutePathBuilder() for added resource URI construction
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build(); 
		
		// we will return Response builder
		// .created() instead of .status(Status.CREATED) to get 201 code
		// and send URI back
		return Response.created(uri)
		               .entity(newMessage)
		               .build();
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
	
	// Subresource DELEGATION: no matter what the HTTP method is over here!
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}


}
