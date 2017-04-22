package br.com.jonas.database;

import java.util.HashMap;
import java.util.Map;

import br.com.jonas.model.Message;
import br.com.jonas.model.Profile;

public class Databaseclass {

	//simulate the database
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
}
