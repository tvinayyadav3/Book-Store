package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) throws SQLException {
		Connection con=BookDatabaseCon.getCon();
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookManage","root","Password");
		Scanner s=new Scanner(System.in);
		int n;
		
		do {
			
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.Exit");
		    n=s.nextInt();
		
		switch(n)
		{
		   	case 1:
		   		System.out.println("Enter Book details");
		   		System.out.println("1.Enter bId");
		   		int id=s.nextInt();
		   		System.out.println("2.Enter bName");
		   		String bName=s.nextLine();
				System.out.println("3.Enter bPrice");
				double bPrice=s.nextDouble();
				Book b=new Book(id,bName,bPrice);
				BookManager.addBook(b,con);
				System.out.println("Book added successfully");
				break;
		   	case 2:
		   		System.out.println("Enter book name to delete");
		   		String dname=s.next();
		   		BookManager.deleteBookByName(con, dname);
		   		System.out.println("Book has been deleted");
		   		break;
		   	case 3:
		   		System.out.println("Enter book name to delete");
		   		String uname=s.next();
		   		double price=s.nextDouble();
		   		BookManager.updateBookByName(con, uname,price);
		   		System.out.println("Book has been updated");
		   		break;
		   	case 4:
		   		System.out.println("Exited");
		   		break;
		   	default:
		   		System.out.println("Inavlid option");
			   		break; 	
			}
			}while(n!=4);
		}

}
