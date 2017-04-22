package br.com.jonas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.jonas.database.Databaseclass;
import br.com.jonas.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Databaseclass.getProfiles();

	
	
	public ProfileService() {
		
		profiles.put("Jonas", new Profile(1L, "Jonas.profile", "Jonas", "Costa"));
		profiles.put("Jonas2", new Profile(2L, "Jonas2.profile", "Jonas2", "Costa2"));
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}else{
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	

}
