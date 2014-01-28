package travelDream.ejb.eaos;

import javax.ejb.Stateless;
import java.security.MessageDigest;

/**
 * Session Bean implementation class SecurityBean
 */
@Stateless
public class SecurityBean{

    /**
     * Default constructor. 
     */
    public SecurityBean() {
        // TODO Auto-generated constructor stub
    	
    }
    
    

    public static String convert(String password)throws Exception
    {
 
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        return sb.toString();

    }

}
