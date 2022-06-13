package Services;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import Repositorities.UserRepository;

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

	public void insertUser(String user_Email, String user_Password, String first_Name, String last_Name, String phone_Number){
		
		correctUser = usersRepository.insertUser(0, 0, user_Email, user_Password, first_Name, last_Name, phone_Number);
	}
}
