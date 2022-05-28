package muleSoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class InsertData {
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

	public void insert(String db, String tbname) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Movie name:");
		String name = scanner.nextLine();
		System.out.println("Enter the Actor name:");
		String actor = scanner.nextLine();
		System.out.println("Enter the Actress name:");
		String actress = scanner.nextLine();
		System.out.println("Enter the Director name:");
		String director = scanner.nextLine();
		System.out.println("Enter the Year of release:");
		int yor = scanner.nextInt();

		String sql = "INSERT INTO " + tbname + "(m_name,actor,actress,director,yor) VALUES(?,?,?,?,?);";

		try {
			Connection conn = this.connect(db);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, actor);
			pstmt.setString(3, actress);
			pstmt.setString(4, director);
			pstmt.setInt(5, yor);
			pstmt.executeUpdate();
			System.out.println("Data Inserted");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
