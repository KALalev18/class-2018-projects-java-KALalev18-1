
package Services;

import java.util.List;
import java.util.stream.Collectors;
import java.sql.SQLException;
import java.util.Collections;

import Models.User_Info;
import Repositorities.UserRepository;
import Utils.PasswordManager;

public class UserService {

	private static UserService instance = null;
	private final UserRepository usersRepository;

	private UserService() throws SQLException {
		this.usersRepository = UserRepository.getInstance();
	}

	public static UserService getInstance() throws SQLException {

		if (UserService.instance == null) {
			UserService.instance = new UserService();
		}

		return UserService.instance;
	}

	public List<User_Info> getAllUsers() {
		List<User_Info> users = usersRepository.getAllUsers();
		return users;
	}

	public List<User_Info> getAllAdmins() {
		List<User_Info> admins = usersRepository.getAllAdmins();

		return admins;
	}

	public void deleteUserById(int userId) {
		usersRepository.deleteUserById(userId);
	}

	public User_Info getRegisteredUser(String firstName, String lastName, String password) {

		User_Info user = usersRepository.getRegisteredUser(firstName, lastName, password);

		if (user != null) {
			boolean hashPassword = PasswordManager.checkPass(password.toCharArray(),
					user.getUser_Password().toCharArray());

			if (hashPassword == false) {
				return null;
			}
		}

		return user;
	}
}
