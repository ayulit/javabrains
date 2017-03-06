package org.koushik.javabrains.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.database.DatabaseClass;
import org.koushik.javabrains.model.Message;

/** Service for data extraction from DB */
public class MessageService {

	// stub for DB: using static class
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	// to hardcode a creation of a few messages
	public MessageService() {
		messages.put(1L, new Message(1, "I'm your father.", "Darth Vader"));
		messages.put(2L, new Message(2, "May the Force be with U.", "Obi-Wan"));
	}
	
	public List<Message> getAllMessages() {		
		return new ArrayList<Message>(messages.values());				
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
}
