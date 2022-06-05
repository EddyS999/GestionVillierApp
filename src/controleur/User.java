package controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User 
{	
	private int iduser;
	private String nom,prenom,email,mdp,role;
	
	
	public User(int iduser, String nom, String prenom, String email, String mdp, String role) {
		
		this.iduser = iduser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	
	}
	public User(String nom, String prenom, String email, String mdp, String role) {
		
		this.iduser = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
		
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDerniereConnexion() {
		String path = "src/controleur/file.txt"; 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String content = ""; 

		try
	    {
	      // Le fichier d'entrée
	      File file = new File(path);    
	      // Créer l'objet File Reader
	      FileReader fr = new FileReader(file);  
	      // Créer l'objet BufferedReader        
	      BufferedReader br = new BufferedReader(fr);  
	      StringBuffer sb = new StringBuffer();    
	      String line;
	      
	      if(file.length() == 0) {
	    	  content =  dtf.format(LocalDateTime.now());
	    	  //Si le fichier est vide 
	    	  try {
	    	      FileWriter fw = new FileWriter(file);
	    	      fw.write(content);
	    	      fw.close();
	    	      System.out.println("Le texte a été écrit avec succès");
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    }
	    	  
	      } 
	   
	      //Si le fichier n'est pas vide on le lit 
	      else {
	    	while((line = br.readLine()) != null){
	        // ajoute la ligne au buffer
	        sb.append(line);      
	        sb.append("\n");     
	      }
	      fr.close();    
	      //System.out.println("Contenu du fichier: ");
	      content = sb.toString(); //on récupère le contenu du fichier pour l'afficher sur la page profil
	      
	      //On vide le fichier 
	      String vidage = content.replaceAll(content, "");
	      PrintWriter writer = new PrintWriter(new File(path)); 
	      writer.append(vidage); 
	      writer.flush();
	      
	      }
	      
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
		
		return content;
	}
	
	
}
