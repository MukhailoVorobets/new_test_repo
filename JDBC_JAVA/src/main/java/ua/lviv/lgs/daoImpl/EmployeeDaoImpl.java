package ua.lviv.lgs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.EmployeeDAO;
import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.utils.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDAO {
	
	public static String READ_ALL = "select * from users";
	private static String CREATE = "insert into users(first_name, last_name) values(?,?)";
	private static String READ_BY_ID = "select * from users where id = ?";
	private static String UBDATE_BY_ID = "update users id = ?, first_name = ?, last_name = ?";
	private static String DELETE_BY_ID = "delete from users where id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	
	public EmployeeDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	public Employee create(Employee employee) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			
			employee.setId(resultSet.getInt(1));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employee;
	}

	public Employee reade(Integer id) {
		
		Employee employee = null;
		
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Integer employeeId = resultSet.getInt("id");
			String employeeFirstName = resultSet.getString("first_name");
			String employeeLastName = resultSet.getString("last_name");
			
			employee = new Employee(employeeId, employeeFirstName, employeeLastName);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  employee;
	}

	public List<Employee> readeAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Integer employeeId = resultSet.getInt("id");
				String employeeFirstName = resultSet.getString("first_name");
				String employeeLastName = resultSet.getString("last_name");
				
				employees.add(new Employee(employeeId, employeeFirstName, employeeLastName));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return employees;
	}

	public Employee update(Employee employee) {
		try {
			preparedStatement = connection.prepareStatement(UBDATE_BY_ID);
			preparedStatement.setInt(1, employee.getId());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	public void delete(Integer id) {
		
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
