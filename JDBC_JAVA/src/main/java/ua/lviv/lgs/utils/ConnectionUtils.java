package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionUtils {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "18061990";
	private static String URL = "jdbc:mysql://Localhost/employee ? serverTimezone=" + TimeZone.getDefault().getID();

	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
