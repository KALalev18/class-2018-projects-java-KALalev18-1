package Services;

import java.sql.SQLException;

import Models.User_Info;

public class AuthenticationService {

	private static AuthenticationService instance = null;
	private final UserService userService;
    
	private User_Info authenticatedUser = null;
	
	private AuthenticationService() throws SQLException {
		this.userService = UserService.getInstance();
    }
	
    public static AuthenticationService getInstance() throws SQLException {

        if (AuthenticationService.instance == null) {
            AuthenticationService.instance = new AuthenticationService();
		}

        return AuthenticationService.instance;
    }

    public User_Info getLoggedUser() {
        return authenticatedUser;
    }

    public void authenticateUser(String firstName, String lastName, String password) {
        this.authenticatedUser = userService.getRegisteredUser(firstName, lastName, password);
    }
    
    public void destroySession() {
    	authenticatedUser = null;  	
    }

}
