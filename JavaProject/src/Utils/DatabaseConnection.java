package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection getConnection() throws SQLException{
		Connection url = DriverManager.getConnection(ApplicationProperties.url);
		return url;
	}

}
