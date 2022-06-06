package Services;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import Repositorities.UserRepository;
import Utils.PasswordManager;

public class RegisterService {
	private final UserRepository usersRepository;
	private static RegisterService instance = null;
	private boolean correctUser;
	
	public static RegisterService getInstance() throws SQLException {

        if (RegisterService.instance == null) {
        	RegisterService.instance = new RegisterService();
		}

        return RegisterService.instance;
    }
	
	private RegisterService() throws SQLException {
        this.usersRepository = UserRepository.getInstance();
    }
	
	public boolean getCorrectUser() {
        return correctUser;
    }

	public void insertUser(int user_ID, int registration_ID, String user_Email, String user_Password, String first_Name, String last_Name, String phone_Number) throws NoSuchAlgorithmException, NoSuchProviderException {
		
		String nesh = PasswordManager.getNext();
		user_Password = PasswordManager.hash(user_Password.toCharArray(), nesh);
		
		correctUser = usersRepository.insertUser(user_ID, registration_ID, user_Email, user_Password, first_Name, last_Name, phone_Number);
	}
}
