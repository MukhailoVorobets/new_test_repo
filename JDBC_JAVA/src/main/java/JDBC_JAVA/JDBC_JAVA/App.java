package JDBC_JAVA.JDBC_JAVA;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import ua.lviv.lgs.dao.EmployeeDAO;
import ua.lviv.lgs.daoImpl.EmployeeDaoImpl;
import ua.lviv.lgs.domain.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Hello World!");

		EmployeeDAO employeeDAO = new EmployeeDaoImpl();

		System.out.println(employeeDAO.reade(3));

		List<Employee> employees = employeeDAO.readeAll();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		
	}
}
