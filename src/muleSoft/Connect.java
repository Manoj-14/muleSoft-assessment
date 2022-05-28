package muleSoft;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class Connect {
	public static void connect(String dbname) {
		String url = "jdbc:sqlite:C:/sqlite/" + dbname + ".db";
		try {
			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean check(String dbName) {
		File file = new File("C:\\sqlite\\" + dbName + ".db");
		if (file.exists()) {
			return true;
		}
		return false;

	}

}
