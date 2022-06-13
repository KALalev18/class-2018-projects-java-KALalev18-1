
package Services;

import java.util.List;
import java.util.stream.Collectors;
import java.sql.SQLException;
import java.util.Collections;

import Models.Admin_Info;
import Models.User_Info;
import Repositorities.UserRepository;

public class UserService {

	private static UserService instance = null;
	private final UserRepository userRepository;
	

	public UserService() throws SQLException {
		this.userRepository = UserRepository.getInstance();
	}

	public static UserService getInstance() throws SQLException {

		if (UserService.instance == null) {
			UserService.instance = new UserService();
		}

		return UserService.instance;
	}

	public Boolean isLogin(String userEmail, String userPassword) {
		return userRepository.emailAndPasswordMatch(userEmail, userPassword);
	}

	public User_Info getLoggedInUser(String userEmail, String userPassword) {
		if (isLogin(userEmail, userPassword)) {
			return userRepository.getUserByEmail(userEmail);
		} else {
			return null;
		}
	}

	public User_Info getUserById(int user_ID) {
		return userRepository.getUserById(user_ID);
	}

	public List<User_Info> getAllUsers() throws SQLException {
		return userRepository.ShowCustomers();
	}

	public Boolean updateUser(int user_ID, String firstName, String lastName, String userPassword) {
		User_Info user = getUserById(user_ID);
		if (user != null) {
			user.setFirst_Name(firstName);
			user.setLast_Name(userPassword);
			user.setUser_Password(userPassword);

			return userRepository.updateUser(user, user_ID);

		} else {
			return false;
		}
	}

	public Boolean deleteUser(int user_ID) throws SQLException {
		return userRepository.DeleteUser(user_ID);
	}
}
