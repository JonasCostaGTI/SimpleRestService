package br.com.jonas.messageResources;

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

import br.com.jonas.model.Message;
import br.com.jonas.service.MessageService;

//@Produces(MediaType.APPLICATION_XML) para xml, model must by @XmlRootElement
//@Produces(MediaType.APPLICATION_JSON) configurar dependencia no pom.xml para realizar a conversao

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();

	
//	@GET
//	public List<Message> getMessages(){
//		return messageService.getAllMessages() ;
//	}

	@GET
	public List<Message> getMessages(@QueryParam("year") int year, 
									 @QueryParam("start") int start, 
									 @QueryParam("size") int size){
		
		if(year > 0){
			return messageService.getAllMessagesforYear(year);
		}
		
		if(start >= 0 && size >= 0){
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages() ;
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessagebyId(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);
		
	}
	
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId){
		return messageService.removeMessage(messageId);
	}
	

}
