package xpug.kata.birthday_greetings;

public class Greetings {

	private String sender;
	private Employee employee;
	
	public Greetings(String sender, Employee employee) {
		this.sender = sender;
		this.employee = employee;
	}
	
	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return employee.getEmail();
	}

	public String getSubject() {
		return "Happy Birthday!";
	}

	public String getBody() {
		return "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
	}
}
