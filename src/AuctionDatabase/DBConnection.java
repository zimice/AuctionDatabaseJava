package AuctionDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	private Connection con = null;
	private String user;
	private String pass;
	private String dbUrl;

	public DBConnection() {
		user = "*****";
		pass = "*****";
		dbUrl = "******";
		connect();
	}

	public DBConnection(String ip, String port, String db, String user, String pass) {
		dbUrl = "jdbc:mysql://" + ip + ":" + port + "/" + db;
		this.user = user;
		this.pass = pass;
		connect();
	}

	private String connect() {
		String result = "Connection Estabileshed";
		try {
			con = DriverManager.getConnection(dbUrl, user, pass);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return e.getMessage();
		}
		System.out.println(result);
		return result;
	}
	private String getWineTypeName(int id) {
		String selectCommand = "SELECT name FROM typeOfWine where id = "+id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectCommand);
			if (rs.next()) {
				return rs.getString(0);
			}
		} catch (SQLException e) {
			System.err.println("Error during selecting records");
			return "NOT FOUND";
		}
		return null;
	}
	public ArrayList<Wine> selectRecords() {
		ArrayList<Wine> wines = new ArrayList<>();
		String selectCommand = "SELECT * FROM WINES";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectCommand);
			while (rs.next()) {
				Wine wine = new Wine(rs.getInt(3), TypeOfWine.valueOf(getWineTypeName(rs.getInt(4))),rs.getString(1), rs.getDouble(5),
						rs.getInt(2));
				System.out.println(wine.toString());
				wines.add(wine);
			}
		} catch (SQLException e) {
			System.err.println("Error during selecting records");
			return new ArrayList<Wine>();
		}

		return wines;
	}

}
