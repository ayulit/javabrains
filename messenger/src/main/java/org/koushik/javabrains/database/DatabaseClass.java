package org.koushik.javabrains.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.model.Profile;

/** Stub for database */
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	static
	{		
		/* to hardcode a creation of a few entries */
		
		messages.put(1L, new Message(1, "I'm your father, Luke", "vader"));
		messages.put(2L, new Message(2, "May the Force be with you", "obi-wan"));
		messages.put(3L, new Message(3, "I've been waiting for you, Obi-Wan", "vader"));
		
		profiles.put("vader", new Profile(1L, "vader", "Darth", "Vader"));
		profiles.put("obi-wan", new Profile(1L, "obi-wan", "Obi-Wan", "Kenobi"));
		
		// TODO think about comments init
	}
		
	public static Map<Long, Message> getMessages() {				
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
