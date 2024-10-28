package bookstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookManager {
	Book obj;
	public static void addBook(Book obj,Connection con) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?)");
		System.out.println(obj.getBookId()+" "+obj.getBookName()+" "+obj.getPrice());
		ps.setInt(1, obj.getBookId());
		ps.setString(2,obj.getBookName());
		ps.setDouble(3,obj.getPrice());
		ps.execute();
		con.commit();
	}
	public static void deleteBookByName(Connection con,String name) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("delete from books where b_Name=?");
		ps.setString(1,name);
		ps.execute();
		con.commit();
	}
	
	public static void updateBookByName(Connection con,String name,double price) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("update books set b_Price=? where b_Name=?");
		ps.setDouble(1, price );
		ps.setString(2, name);
		ps.execute();
		con.commit();
		con.commit();
	}
}
