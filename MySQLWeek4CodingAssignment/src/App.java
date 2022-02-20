import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		
		Connection conn;
		Scanner in = new Scanner(System.in);
		int action = 0;
		String PW;
		
		//Asks user for password, lets you retry.
		System.out.print("Password: ");
			do {
			
				PW = in.nextLine();
		
					try {
						conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/data_to_sell","root",PW);
						System.out.println("Connected!\r\n"
								+ "This is the data base of all our data to sell I mean err... Valued customers!\r\n"
								+ "");
						break;
			
					} catch (SQLException e) {
						System.out.println("Error!");
					}
					System.out.print("Try again: ");
			}while (true);
		
		//Will ask the user at least once, what action they would like to perform on the database.
		System.out.println("What action would you like to perform on the database?");	
			do {
				System.out.println("Enter the number next to action to select.\r\n"
						+ "1) Select (read)\r\n"
						+ "2) Insert (write)\r\n"
						+ "3) Update (edit)\r\n"
						+ "4) Delete...\r\n"
						+ "5) Exit program");
				
					//Check if user enters a number.
					if(in.hasNextInt()){
						action = in.nextInt();
							if (action >= 1 && action <= 5) { //checks if it's a valid number. Than performs the method for action.
									if (action == 5) {
										in.close();
										System.out.println("Thank you for using BananaCORP softwares, Goodbye!");
										break;
									}else if (action == 1) {		//these are the actual methods that perform the requested actions.
										select(conn, in);			//read
									}else if (action == 2) {
										insertInto(conn, in);		//write
									}else if (action == 3) {
										update(conn, in);			//edit
									}else if (action == 4) {
										delete(conn, in);			//delete
									}
								
								System.out.println("Do you want to perform another action?");
							}else {
								System.out.println(action + " is not a valid option.");
							}
					}else {
						in.nextLine();
						System.out.println("1-5 are the only valid options.");
					}
					
			}while (true);
		
	}
	public static void select (Connection conn, Scanner in) throws SQLException {
		//these are my queries. Since they are simple and won't  be concatenated in any way, I figured they do not need to be prepared statements.
		final String getUser = "select username from money_or_user";
		final String getFood = "select username, favorite_food from money_or_user";
		final String getEmail = "select username, email from money_or_user";
		final String getAll = "select * from money_or_user";
		//SQL statement & result set classes.
		Statement stat = null;
			try {
				stat = conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		ResultSet rs = null;
		//int used for selection.
		int column = 0;
		
		System.out.println("What data would you like to sell? I MEAN.. view?\r\n"
				+ "1) Username\r\n"
				+ "2) Favorite Food\r\n"
				+ "3) Email\r\n"
				+ "4) All the data!\r\n"
				+ "");
			if(in.hasNextInt()){
				column = in.nextInt();
					if (column >= 1 && column <= 4) {
						
						if (column == 1) {
							//All Usernames to a result set.
								try {
									rs = stat.executeQuery(getUser);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								//print all the users.
							System.out.println("--------------------------------------------------------");
								while (rs.next()) {
									System.out.println(rs.getString(1));
								}
							System.out.println("--------------------------------------------------------");
						}else if (column == 2) {
							//All fav foods to a result set.
								try {
									rs = stat.executeQuery(getFood);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								//print all the users fav food.
							System.out.println("--------------------------------------------------------");
								while (rs.next()) {
									System.out.println(rs.getString(1) + "'s favorite food is " + rs.getString(2) + ".");
								}
							System.out.println("--------------------------------------------------------");
						}else if (column == 3) {
							//All emails to a result set.
								try {
									rs = stat.executeQuery(getEmail);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								//print all the Emails.
							System.out.println("--------------------------------------------------------");
								while (rs.next()) {
									System.out.println(rs.getString(1) + "'s email is " + rs.getString(2));
								}
							System.out.println("--------------------------------------------------------");
						}else if (column == 4) {
							//All the data to a result set.
								try {
									rs = stat.executeQuery(getAll);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								//print all the data!
							System.out.println("--------------------------------------------------------");
								while (rs.next()) {
									//Example:
									//Customer ID (1) |Username "Country momma" |Favorite Food: "anything deep fried" |Email: "Emailhere@myemail.com"
									System.out.println
										("Customer ID (" + rs.getString(1) + ")"
												+ " |Username: \"" +rs.getString(2)
												+ "\" |Favorite Food: \"" + rs.getString(3) 
												+ "\" |Email: \"" + rs.getString(4) + "\"");
								}
							System.out.println("--------------------------------------------------------");
						}
					}else {
						System.out.println(column + " is not a valid option.");
					}
			}else {
				in.nextLine();
				System.out.println("1-4 are the only valid options.");
			}
		
	}

	public static void insertInto (Connection conn, Scanner in) {
		//Entries.
		String userN = "";
		String favFood = "";
		String email = "";
		String passW = "";
		
		//Statement class
		Statement stat = null;
			try {
				stat = conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			do {	//Set the username string
				System.out.print("Enter Username: ");
				userN = in.nextLine();
					if (userN.length() > 20 || userN.length() < 3) {
						System.out.println("Username must be no longer than 20 and no shorter than 3 characters long.");
					}else {
						break;
					}
			}while (true);
			
			do {	//Set the favorite food string
				System.out.print("Enter favorite food: ");
				favFood = in.nextLine();
					if (favFood.length() > 20 || favFood.length() < 3) {
						System.out.println("Favorite food must be no longer than 20 and no shorter than 3 characters long.");
					}else {
						break;
					}
			}while (true);
			
			do {	//Set the email string
				System.out.print("Enter email: ");
				email = in.next();
					if (email.contains("@") && email.contains(".")) {
						break;
					}else {
						System.out.println("Not valid email.");
					}
			}while (true);
			
			do {	//Set the favorite food string
				System.out.print("Enter password: ");
				passW = in.next();
					if (passW.length() >= 8) {
						break;
					}else {
						System.out.println("Password must be at least 8 characters long.");
					}
			}while (true);
		
		try {
			stat.executeUpdate("insert into money_or_user (username, favorite_food, email, password_)"
					+ "values ('" + userN + "', '" + favFood + "', '" + email + "', '" + passW + "')");
		} catch (SQLException e) {
			System.out.println("Task failed successfully!");
			e.printStackTrace();
		}
		
	}
	
	public static void update (Connection conn, Scanner in) throws SQLException {
		
		int select = 0;
		String updates = "";
		//SQL statement & result set classes.
		Statement stat = null;
			try {
				stat = conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		ResultSet rs = null;
		
		//List all entries and ask what to update.
			try {
				rs = stat.executeQuery("select * from money_or_user");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//print all the data!
		System.out.println("--------------------------------------------------------");
			while (rs.next()) {
				//Example:
				//Customer ID (1) |Username "Country momma" |Favorite Food: "anything deep fried" |Email: "Emailhere@myemail.com"
				System.out.println
					("Customer ID (" + rs.getString(1) + ")"
					+ " |Username: \"" +rs.getString(2)
					+ "\" |Favorite Food: \"" + rs.getString(3) 
					+ "\" |Email: \"" + rs.getString(4) + "\"");
			}
		System.out.println("--------------------------------------------------------");
		
			do {
				System.out.print("Select customer ID to update: ");
					if (in.hasNextInt()) {
						select = in.nextInt();
						break;
					}
				System.out.println("Your selection can only be a number up to the amount of records on the table!");
			}while (true);
		
		System.out.println("Update Username: \r\n"
				+ "Leave this field empty if you do not want to update.");
		updates = in.nextLine();	//fix for that weird nextLine bug. Without this duplicate it will skip input. This is a known bug. https://bugs.openjdk.java.net/browse/JDK-8170457
		updates = in.nextLine();
			if (updates.length() >= 4 && updates.length() <= 20)
				stat.executeUpdate("update money_or_user set username = '" + updates + "' where id = " + select + ";");

		System.out.println("Update favorite food: \r\n"
				+ "Leave this field empty if you do not want to update.");
		updates = in.nextLine();
			if (updates.length() >= 4 && updates.length() <= 20)
				stat.executeUpdate("update money_or_user set favorite_food = '" + updates + "' where id = " + select + ";");

		System.out.println("Update email: \r\n"
				+ "Leave this field empty if you do not want to update.");
		updates = in.nextLine();
			if (updates.length() >= 4)
				stat.executeUpdate("update money_or_user set email = '" + updates + "' where id = " + select + ";");

		System.out.println("Update password: \r\n"
				+ "Leave this field empty if you do not want to update.");
		updates = in.nextLine();
			if (updates.length() >= 8 && updates.length() <= 20)
				stat.executeUpdate("update money_or_user set password_ = '" + updates + "' where id = " + select + ";");
		
	}
	
	public static void delete (Connection conn, Scanner in) throws SQLException {
		
		int select = 0;
		//SQL statement & result set classes.
		Statement stat = null;
			try {
				stat = conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		ResultSet rs = null;
		
		//List all entries and ask what to update.
			try {
				rs = stat.executeQuery("select * from money_or_user");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//print all the data!
		System.out.println("--------------------------------------------------------");
			while (rs.next()) {
				//Example:
				//Customer ID (1) |Username "Country momma" |Favorite Food: "anything deep fried" |Email: "Emailhere@myemail.com"
				System.out.println
					("Customer ID (" + rs.getString(1) + ")"
					+ " |Username: \"" +rs.getString(2)
					+ "\" |Favorite Food: \"" + rs.getString(3) 
					+ "\" |Email: \"" + rs.getString(4) + "\"");
			}
		System.out.println("--------------------------------------------------------");
		
			do {
				System.out.print("Select customer ID to delete: ");
					if (in.hasNextInt()) {
						select = in.nextInt();
						break;
					}
				System.out.println("Your selection can only be a number up to the amount of records on the table!");
			}while (true);
		
		stat.executeUpdate("delete from money_or_user where id = " + select + ";");
		System.out.println("Each time you remove a record that is precious data lost! You will pay too! -$50 from this weeks paycheck for you!");
	}
}
