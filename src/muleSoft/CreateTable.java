package muleSoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void createNewTable(String dbName, String table_name) {
		String url = "jdbc:sqlite:C://sqlite/" + dbName + ".db";
		String sql = "CREATE TABLE IF NOT EXISTS " + table_name + " (m_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " m_name TEXT NOT NULL, " + "actor  TEXT NOT NULL, " + " actress  TEXT NOT NULL, "
				+ "director  TEXT NOT NULL," + "yor INTEGER NOT NULL); ";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void listTables(String dbName) {
		System.out.println("List of tables in the database:");
		String url = "jdbc:sqlite:C://sqlite/" + dbName + ".db";

		String sql = "SELECT name FROM sqlite_schema WHERE type='table' ORDER BY name";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
