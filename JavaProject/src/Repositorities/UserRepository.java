package Repositorities;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Models.Admin_Info;
import Models.User_Info;
import Services.UserService;
import Utils.DatabaseConnection;
import Utils.Utils;

public class UserRepository {
	private static String url = "jdbc:sqlserver://SD2324\\sqlexpress;databaseName=Project_Database;integratedSecurity=true";
	private static Connection conn;
	private static UserRepository instance = null;

	public static UserRepository getInstance() throws SQLException {

		if (UserRepository.instance == null) {
			UserRepository.instance = new UserRepository();
		}

		return UserRepository.instance;
	}

	public UserRepository() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}

	public boolean insertUser(int user_ID, int registration_ID, String user_Email, String user_Password,
			String first_Name, String last_Name, String phone_Number) {
		String query1 = "INSERT INTO dbo.User_Info (user_ID, registration_ID, user_Email, user_Password, first_Name, last_Name, phone_Number) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String query2 = "SELECT * FROM dbo.User_Info WHERE first_Name = ?";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement pst1 = conn.prepareStatement(query1);
				PreparedStatement pst2 = conn.prepareStatement(query2)) {

			pst2.setInt(1, user_ID);

			ResultSet resultSet = pst2.executeQuery();

			if (resultSet.next() == true) {
				return false;
			} else {
				pst1.setInt(1, user_ID);
				pst1.setInt(2, registration_ID);
				pst1.setString(3, user_Email);
				pst1.setString(4, user_Password);
				pst1.setString(5, first_Name);
				pst1.setString(6, last_Name);
				pst1.setString(7, phone_Number);

				int rs = pst1.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public Boolean addUser(User_Info user) {
		if (EmailExists(user.getUser_Email())) {
			return false;
		}

		if (user.getUser_Password().length() < 8) {
			return false;
		}
		String query = "INSERT INTO dbo.User_Info (User_ID, Registration_ID, User_Email, User_Password, First_Name, Last_Name, Phone_Number) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url);

				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setInt(1, user.getUser_ID());
			ps.setInt(2, user.getRegistration_ID());
			ps.setString(3, user.getUser_Email());
			ps.setString(4, user.getUser_Password());
			ps.setString(5, user.getFirst_Name());
			ps.setString(6, user.getLast_Name());
			ps.setString(7, user.getPhone_Number());

			int row = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean EmailExists(String user_Email) {
		User_Info user = null;
		String query = "SELECT * FROM dbo.User_Info WHERE User_Email = ?;";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, user_Email);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public static List<User_Info> ShowCustomers() throws SQLException {
		String query1 = "SELECT * FROM dbo.User_Info";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String custFmt = String.format("%d %d %s %s %s %s %s", rs.getInt("User_ID"), rs.getInt("Registration_ID"),
					rs.getString("User_Email"), rs.getString("User_Password"), rs.getString("First_Name"),
					rs.getString("Last_Name"), rs.getString("Phone_Number"));
			System.out.println(custFmt);
		}
		return null;
	}

	// shows the first name of the customer with id "id"
	public void ShowCustomersByID(int user_ID) throws SQLException {
		// String idStr = id.toString();
		String query1 = "SELECT * FROM dbo.User_Info " + "WHERE User_ID = ?";

		PreparedStatement ps = conn.prepareStatement(query1);

		ps.setInt(1, user_ID);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			;
			String custFmt = String.format("%d %d %s %s %s %s %s", rs.getInt("User_ID"), rs.getInt("Registration_ID"),
					rs.getString("User_Email"), rs.getString("User_Password"), rs.getString("First_Name"),
					rs.getString("Last_Name"), rs.getString("Phone_Number"));
			System.out.println(custFmt);
		}
	}

	public boolean UpdateCustomer(int user_ID, User_Info user) throws SQLException {
		if (user.getUser_Password().length() < 8) {
			return false;
		}

		if (userExists(user_ID)) {
			String query = "UPDATE dbo.User_Info SET Registration_ID = ?, User_Email = ?, User_Password = ?, First_Name = ?, Last_Name = ?, Phone_Number = ? WHERE User_ID = ?";

			try (Connection conn = DriverManager.getConnection(url);

					PreparedStatement ps = conn.prepareStatement(query)) {

				ps.setInt(1, user.getUser_ID());
				ps.setInt(2, user.getRegistration_ID());
				ps.setString(3, user.getUser_Email());
				ps.setString(4, user.getUser_Password());
				ps.setString(5, user.getFirst_Name());
				ps.setString(6, user.getLast_Name());
				ps.setString(7, user.getPhone_Number());

				int row = ps.executeUpdate();

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean DeleteUser(int user_ID) throws SQLException {
		if (userExists(user_ID)) {
			String query = "DELETE FROM dbo.User_Info WHERE User_ID = ?";

			try (Connection conn = DriverManager.getConnection(url);

					PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setLong(1, user_ID);

				int row = ps.executeUpdate();

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public List<User_Info> GetCustomersByID(Integer id) throws SQLException {
		List<User_Info> customers = new ArrayList<>();
		String idStr = id.toString();
		String query1 = "SELECT * FROM dbo.User_Info " + "WHERE User_ID = ?";

		// Statement stmt = conn.createStatement(query1);

		PreparedStatement ps = conn.prepareStatement(query1);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String custFmt = String.format("%d %d %s %s %s %s %s", rs.getInt("User_ID"), rs.getInt("Registration_ID"),
					rs.getString("User_Email"), rs.getString("User_Password"), rs.getString("First_Name"),
					rs.getString("Last_Name"), rs.getString("Phone_Number"));
			System.out.println(custFmt);
		}
		return customers;
	}

	

	public List<Admin_Info> getAllAdmins() {
		List<Admin_Info> listOfAdmins = new ArrayList<>();
		String query = "SELECT * FROM dbo.Admin_Info WHERE Admin_ID = ?";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Admin_Info admin = mapToAdmin(rs);
				listOfAdmins.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfAdmins;
	}
//
//	public List<User_Info> getAllUsers() {
//		List<User_Info> users = new ArrayList<>();
//		String query = "SELECT * FROM dbo.User_Info WHERE Admin = '0';";
//		try (Connection conn = DriverManager.getConnection(url);
//				PreparedStatement ps = conn.prepareStatement(query);
//				ResultSet rs = ps.executeQuery()) {
//
//			while (rs.next()) {
//				User_Info user = mapToUser(rs);
//				users.add(user);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return users;
//	}

	public User_Info getUserById(int user_ID) {
		User_Info user = null;
		String query = "SELECT * FROM dbo.User_Info WHERE User_ID = ?;";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setLong(1, user_ID);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public Boolean updateUser(User_Info user, int userId) {
		if (user.getUser_Password().length() < 8) {
			return false;
		}

		if (userExists(userId)) {
			String query = "UPDATE dbo.User_Info SET User_ID = ?, userName = ?, userPassword = ?, isAdmin = ? WHERE userId = ?";

			try (Connection conn = DriverManager.getConnection(url);

					PreparedStatement ps = conn.prepareStatement(query)) {

				ps.setInt(1, user.getUser_ID());
				ps.setString(2, user.getUser_Email());
				ps.setString(3, user.getUser_Password());
				ps.setString(4, user.getFirst_Name());
				ps.setString(5, user.getLast_Name());

				int row = ps.executeUpdate();

				// rows affected
				if (row == 1) {
					return true;
				} else {
					return false;
				}

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	private boolean userExists(int userId) {
		User_Info user = getUserById(userId);

		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean emailAndPasswordMatch(String userEmail, String userPassword) {
		User_Info user = null;
		String query = "SELECT * FROM dbo.User_Info WHERE User_Email = ? AND User_Password = ?;";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, userEmail);
			ps.setString(2, userPassword);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public User_Info getUserByEmail(String userEmail) {
		User_Info user = null;
		String query = "SELECT * FROM users WHERE userName = ?;";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, userEmail);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public static User_Info mapToUser(ResultSet rs) throws SQLException {
		int user_ID = rs.getInt("Admin_ID");
		int registration_ID = rs.getInt("Registration_ID");
		String user_Email = rs.getString("User_Email");
		String user_Password = rs.getString("User_Password");
		String first_Name = rs.getString("First_Name");
		String last_Name = rs.getString("Last_Name");
		String phone_Number = rs.getString("Phone_Number");
		User_Info user = new User_Info(user_ID, registration_ID, user_Email, user_Password, first_Name, last_Name,
				phone_Number);
		return user;
	}

	public static Admin_Info mapToAdmin(ResultSet rs) throws SQLException {
		int admin_ID = rs.getInt("Admin_ID");
		String admin_Email = rs.getString("Admin_Email");
		String admin_Password = rs.getString("Admin_Password");
		String admin_First_Name = rs.getString("Admin_First_Name");
		String admin_Last_Name = rs.getString("Admin_Last_Name");
		String admin_Phone_Number = rs.getString("Admin_Phone_Number");
		Admin_Info admin = new Admin_Info(admin_ID, admin_Email, admin_Password, admin_First_Name, admin_Last_Name,
				admin_Phone_Number);
		return admin;
	}

	public User_Info getRegisteredUser(String email) {
		User_Info user = null;
		String query = "SELECT * FROM dbo.User_Info WHERE Username = ?";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = getPSWithEmail(conn, query, email);
				ResultSet resultSet = ps.executeQuery()) {
			
			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	private PreparedStatement getPSWithEmail(Connection conn, String query, String email) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email);
		return ps;
	}
}