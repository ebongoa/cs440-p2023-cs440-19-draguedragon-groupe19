package fr.esisar.draguedragon.bd.connexion;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.esisar.draguedragon.entities.DragueDragon;

/**
 * Permet de creer un un fichier Json
 * 
 * @author laurenal
 *
 */


public class JsonFile {
	
	private static JsonFile jsonFile = null;
	
	private File file;
	
	private DragueDragon dragueDragon;

	private JsonFile(String pathname) {
		super();
		this.file = new File(pathname);
		this.dragueDragon = new DragueDragon();
	}
	
	
	/**
	 * 
	 * @return Un JsonFile associe au fichier Json donnee dans la classe Constants (a avant si elle n'existe pas deja)
	 */
	public final static JsonFile getInstance() {
		synchronized(JsonFile.class) {
			if(JsonFile.jsonFile==null) {
				JsonFile.jsonFile = new JsonFile(Constants.pathname);

			}
		}
		return JsonFile.jsonFile;
	}
	
	/**
	 * 
	 * @return Le pathname du fichier Json
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * 
	 * @return Renvoie un element dragueDragon qui contient tous les elements present dans le fichier Json dont le pathname est présiser dans la classe Constants
	 */
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
	
	/**
	 * 
	 * @param dragueDragon contient la nouvelle base de donnee(sous forme de listes) a ecrire dans un fichier Json
	 */
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
