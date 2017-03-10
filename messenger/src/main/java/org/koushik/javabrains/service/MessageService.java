package org.koushik.javabrains.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.database.DatabaseClass;
import org.koushik.javabrains.model.Message;

/** Service for data's interaction with DB */
public class MessageService {

	// stub for DB: using static class
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages() {		
		return new ArrayList<Message>(messages.values());				
	}
	
	// filtering
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageForYear = new ArrayList<>(); // blank list for return
		Calendar cal = Calendar.getInstance();            // for easy comparison
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}
		}		
		return messageForYear;		
	}
	
	// pagination
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		// getting some validation: 
		if (start + size > list.size()) return new ArrayList<Message>(); 
		return list.subList(start, start + size);		
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
