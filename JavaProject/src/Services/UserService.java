
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
	private final UserRepository usersRepository;

	public UserService() throws SQLException {
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

	public List<Admin_Info> getAllAdmins() {
		List<Admin_Info> admins = usersRepository.getAllAdmins();

		return admins;
	}

	public void deleteUserById(int userId) throws SQLException {
		usersRepository.DeleteCustomer(userId);
	}

	public User_Info getRegisteredUser(String firstName, String lastName, String password) {

		User_Info user = usersRepository.getRegisteredUser(firstName, lastName, password);
		return user;
	}
}
