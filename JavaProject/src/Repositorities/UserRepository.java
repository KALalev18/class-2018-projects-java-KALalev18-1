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

	public User_Info getRegisteredUser(String firstName, String lastName, String password) {
		User_Info user = null;
		String query = "SELECT * FROM users WHERE First_Name = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = getPSWithName(conn, query, firstName, lastName, password);
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

	public void UpdateCustomer(int id, String firstName, String lastName) throws SQLException {
		String query = "UPDATE dbo.User_Info " + "SET First_Name = ?, Last_Name = ? " + "WHERE User_ID = ?";

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, id);

		int rs = ps.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void DeleteCustomer(int id) throws SQLException {
		String query = "DELETE dbo.User_Info " + "WHERE User_ID = ?";

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);

		int rs = ps.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
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

	private PreparedStatement getPSWithName(Connection conn, String query, String firstName, String lastName, String password) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		return ps;
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

	public boolean insertUser(String user_Email, String user_Password, String first_Name, String last_Name,
			String phone_Number) {
		String query1 = "INSERT INTO dbo.User_Info (First_Name, Last_Name, User_Email, User_Password, Phone_Number) VALUES (?, ?, ?, ?, ?)";
		String query2 = "SELECT * FROM dbo.User_Info WHERE First_Name = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst1 = conn.prepareStatement(query1);
				PreparedStatement pst2 = conn.prepareStatement(query2)) {

			ResultSet resultSet = pst2.executeQuery();

			if (resultSet.next() == true) {
				return false;
			} else {
				pst1.setString(1, user_Email);
				pst1.setString(2, user_Password);
				pst1.setString(3, first_Name);
				pst1.setString(4, last_Name);
				pst1.setString(5, phone_Number);

				int rs = pst1.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<User_Info> getAllUsers() {
		List<User_Info> users = new ArrayList<>();
		String query = "SELECT * FROM dbo.User_Info WHERE Admin = '0';";
		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				User_Info user = mapToUser(rs);
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
}