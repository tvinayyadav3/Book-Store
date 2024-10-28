package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDatabaseCon {
	public static Connection getCon() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookManager","root","Password");
		con.setAutoCommit(false);
		return con;
	}

}

 