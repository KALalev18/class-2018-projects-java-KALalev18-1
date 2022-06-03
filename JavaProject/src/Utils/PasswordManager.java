package Utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordManager {
	
	private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 256;

    private PasswordManager() { }

    public static String hash(char[] password, String salt) 
    {
        PBEKeySpec spec = new PBEKeySpec(password, Base64.getDecoder().decode(salt), ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try 
        {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return Base64.getEncoder().encodeToString(skf.generateSecret(spec).getEncoded());
        } 
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) 
        {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } 
        finally
        {
            spec.clearPassword();
        }
    }

    public static boolean isExpectedPassword(char[] password, char[] expectedHash)
    {
        char[] pwdHash = hash(password, null).toCharArray();
        Arrays.fill(password, Character.MIN_VALUE);
        if (pwdHash.length != expectedHash.length)
        {
        	return false;
        }
        for (int i = 0; i < pwdHash.length; i++)
        {
            if (pwdHash[i] != expectedHash[i]) 
            {
            	return false;
            }
        }
        return true;
    }

	public static String getNext() {
		// TODO Auto-generated method stub
		return "  ";
	}
}