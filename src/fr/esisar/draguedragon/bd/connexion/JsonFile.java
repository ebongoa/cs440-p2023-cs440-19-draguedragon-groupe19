package fr.esisar.draguedragon.bd.connexion;

import java.io.File;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.esisar.draguedragon.entities.DragueDragon;

public class JsonFile {
	
	private static JsonFile jsonFile = null;
	
	private File file;
	
	private DragueDragon dragueDragon;

	private JsonFile(String pathname) {
		super();
		this.file = new File(pathname);
	}
	
	public final static JsonFile getInstance() {
		synchronized(JsonFile.class) {
			if(JsonFile.jsonFile==null) {
				JsonFile.jsonFile = new JsonFile(Constants.pathname);

			}
		}
		return JsonFile.jsonFile;
	}
	
	public File getFile() {
		return file;
	}
	
	public DragueDragon loadFile() {
		ObjectMapper sMapper = new ObjectMapper();
		
	    String dragueDragonJson = "";    
	    try {  
	        dragueDragonJson = "";
	        this.dragueDragon = sMapper.readValue(dragueDragonJson,DragueDragon.class);  
	    } catch (JsonParseException e) {  
	        e.printStackTrace();  
	    } catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    return this.dragueDragon;
	}
	
	public void saveFile(DragueDragon dragueDragon) {
		
	}
}
