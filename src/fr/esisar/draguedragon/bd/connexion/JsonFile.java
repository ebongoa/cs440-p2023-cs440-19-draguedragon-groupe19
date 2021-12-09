package fr.esisar.draguedragon.bd.connexion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.dragueDragon = mapper.readValue(file, DragueDragon.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return this.dragueDragon;
	}
	
	public void saveFile(DragueDragon dragueDragon) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(this.file, dragueDragon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
