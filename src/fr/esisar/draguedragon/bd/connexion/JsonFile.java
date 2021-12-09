package fr.esisar.draguedragon.bd.connexion;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.esisar.draguedragon.entities.DragueDragon;

public class JsonFile {
	
	private static JsonFile jsonFile = null;
	
	private File file;
	
	private DragueDragon dragueDragon;

	private JsonFile(String pathname) {
		super();
		this.file = new File(pathname);
		this.dragueDragon = new DragueDragon();
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
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(file.length()!=0) {
				this.dragueDragon = mapper.readValue(file, DragueDragon.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return this.dragueDragon;
	}
	
	public void saveFile(DragueDragon dragueDragon) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		try {
			writer.writeValue(this.file, dragueDragon);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
