package Repositorities;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Models.User_Info;
import Utils.DatabaseConnection;
import Utils.Utils;

public class UserRepository {
	private static String url = "jdbc:sqlserver://SD2324\\sqlexpress;databaseName=Project_Database;integratedSecurity=true";
	// private static UserRepository instance = null;
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

	public static User_Info mapToUser(ResultSet rs) throws SQLException {
		int user_ID = rs.getInt("User_ID");
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

	public List<User_Info> getUsers() throws SQLException {
		List<User_Info> listOfUsers = new ArrayList<>();
		String query1 = "SELECT * FROM dbo.User_Info";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(query1);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				User_Info user = mapToUser(resultSet);
				listOfUsers.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}

	public static List<User_Info> getAllUsers() {
		List<User_Info> listOfUsers = new ArrayList<>();
		String query = "SELECT * FROM dbo.User_Info;";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				User_Info user = mapToUser(rs);
				listOfUsers.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}

	public User_Info getRegisteredUser(String firstName, String lastName, String password) {
		User_Info user = null;
		String query = "SELECT * FROM users WHERE First_Name = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = getPSWithNames(conn, query, firstName, lastName, password);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				user = mapToUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
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
	public void ShowCustomersByID(Integer id) throws SQLException {
		// String idStr = id.toString();
		String query1 = "SELECT * FROM dbo.User_Info " + "WHERE User_ID = ?";

		// Statement stmt = conn.createStatement(query1);

		PreparedStatement ps = conn.prepareStatement(query1);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			;
			String custFmt = String.format("%d %d %s %s %s %s %s", rs.getInt("User_ID"), rs.getInt("Registration_ID"),
					rs.getString("User_Email"), rs.getString("User_Password"), rs.getString("First_Name"),
					rs.getString("Last_Name"), rs.getString("Phone_Number"));
			System.out.println(custFmt);
		}
	}

	// update the first name of the customer with id "id"
	public void UpdateCustomer(int id, String firstName, String lastName) throws SQLException {
		String query = "UPDATE dbo.User_Info " + "SET First_Name = ?, Last_Name = ? " + "WHERE User_ID = ?";

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, id);

		int rs = ps.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	/*
	 * public void DeleteCustomer(int id) throws SQLException { String query =
	 * "DELETE dbo.User_Info " + "WHERE User_ID = ?";
	 * 
	 * PreparedStatement ps = conn.prepareStatement(query); ps.setInt(1, id);
	 * 
	 * int rs = ps.executeUpdate();
	 * 
	 * System.out.println(String.format("Rows affected: %d", rs)); }
	 */

	public void deleteUserById(int userID) {
		String query1 = "DELETE FROM users WHERE User_ID = ?";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement pst1 = conn.prepareStatement(query1)) {

			pst1.setInt(1, userID);

			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	private PreparedStatement getPSWithNames(Connection conn, String query, String firstName, String lastName,
			String password) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, password);
		return ps;
	}

	

	public List<User_Info> getAllAdmins() {
		List<User_Info> listOfUsers = new ArrayList<>();
		String query = "SELECT * FROM users WHERE Admin = '1';";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				User_Info user = mapToUser(resultSet);
				listOfUsers.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}
}