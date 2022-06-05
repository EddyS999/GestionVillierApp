package controleur;




import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


  

import modele.Modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class PPE_Darren
{
	private static VueConnexion uneConnexion;
	private static VueGenerale uneVueGenerale;
	
	public static void rendreVisibleVueConnexion(boolean action)
	{
		uneConnexion.setVisible(action);
	}
	
	public static void rendreVisibleVueGenerale(boolean action)
	{
		uneConnexion.setVisible(action);
	}
	
	public static void instancierVueGenerale(User unUser)
	{
		uneVueGenerale = new VueGenerale(unUser);
	}
	
	public static void fermerVueGenerale()
	{
		uneVueGenerale.dispose(); //d�truire la vue
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{	
		uneConnexion = new VueConnexion();
		
		
		
		
		/*String mdp = "123"; 
	
		System.out.println("(avant) mdp = "+mdp);
		for(int i = 0; i < 1000000; i++) {
			mdp = md5(mdp);//On crypte 100 fois le mdp 
			
		}
		
		System.out.println("(apres) mdp = "+mdp);
		*/
		
		
	}

	
	
	
	
	
	
	//******************GESTION DES USERS*********************
	public static User selectWhereUser(String email, String mdp)
	{
		// on re�oit l'email et le mdp : et on r�alise le controle
		//de l'email et le cryptage du mdp 
		
		User unUser = Modele.selectWhereUser(email, mdp);
		
		return unUser;
	}
	
	//modifiation : 22/04 - hachage mdp 
		public static byte[] getSHA(String mdp) 
	    { 
			byte[] tab = null;
			
			try {
				
			
	        //Static getInstance method is called with hashing SHA 
	        MessageDigest md = MessageDigest.getInstance("SHA1"); 
	        tab = md.digest(mdp.getBytes(StandardCharsets.UTF_8)); 
	        // digest() method called 
	        // to calculate message digest of an input 
	        // and return array of byte
			 }
			catch(NoSuchAlgorithmException exp)
			{
				exp.printStackTrace();
			}
			return tab;
	    }
		
		
		
		
		public static byte[] getMD5(String mdp) 
	    { 
			byte[] tab = null;
			
			try {
				
			
	        //Static getInstance method is called with hashing SHA 
	        MessageDigest md = MessageDigest.getInstance("MD5"); 
	        tab = md.digest(mdp.getBytes(StandardCharsets.UTF_8)); 
	        // digest() method called 
	        // to calculate message digest of an input 
	        // and return array of byte
			 }
			catch(NoSuchAlgorithmException exp)
			{
				exp.printStackTrace();
			}
			return tab;
	    }
	    
	    public static String toHexString(byte[] tab)
	    {
	        // Convert byte array into signum representation 
	        BigInteger number = new BigInteger(1, tab); 
	  
	        // Convert message digest into hex value 
	        StringBuilder hexString = new StringBuilder(number.toString(16)); 
	  
	        // Pad with leading zeros
	        while (hexString.length() < 32) 
	        { 
	            hexString.insert(0, '0'); 
	        } 
	  
	        return hexString.toString(); 
	    }
	    
	    public static String md5(String mdp) {
	    	return toHexString(getMD5(mdp)); 
	    }
		
	    public static String crypterMdp(String mdp)
	    {
	    	//hashage en md5
	    	
	    	return toHexString(getSHA(mdp));
	    }

}
