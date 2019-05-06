package xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {

	String fileName;
	
	public FileEmployeeRepository(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public List<Employee> getEmployees() {
		try {
			List<Employee> resp = new ArrayList<Employee>();
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str = "";
			str = in.readLine();
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				resp.add(employee);
			}
			return resp;
		}
		catch(Exception e) {
			return null;
		}
	}

}
