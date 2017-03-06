package org.koushik.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.model.Message;

/** Service for data extraction from DB */
public class MessageService {

	
	public List<Message> getAllMessages() {
		
		/* just hardcode here, for example */
		
		Message m1 = new Message(1L, "Help me, Obi-Wan!", "Princess Lea");
		Message m2 = new Message(2L, "Use the force, Luke!", "Obi-Wan");
		
		List<Message> list = new ArrayList<>();
		
		list.add(m1);
		list.add(m2);
		
		return list;		
	}
}
