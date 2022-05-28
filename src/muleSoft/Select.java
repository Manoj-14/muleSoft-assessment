package muleSoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.*;

public class Select {
	private Connection connect(String dbName) {
		String url = "jdbc:sqlite:C:/sqlite/" + dbName + ".db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conn;
	}

	public void selectAll(String db, String tblName) {
		String sql = "SELECT * FROM " + tblName;

		try {
			Connection conn = this.connect(db);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Movie Name", "Actor", "Actress", "Director",
					"Year of release");

			while (rs.next()) {
				System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", rs.getString("m_name"), rs.getString("actor"),
						rs.getString("actress"), rs.getString("director"), rs.getInt("yor"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectByActor(String db, String tblName, String actorName) {

		String sql = "SELECT * " + "FROM " + tblName + " WHERE actor = ?";

		try {
			Connection conn = this.connect(db);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, actorName);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("m_id") + "\t" + rs.getString("m_name") + "\t" + rs.getString("actor")
						+ "\t" + rs.getString("actress"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
		}
	}
}
