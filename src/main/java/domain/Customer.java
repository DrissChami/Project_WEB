package domain;

public class Customer {
	private int id;
	private String name;
	private String email;
	private int age;
	private boolean haveLicence;

	public Customer(int id, String name, String email, int age, boolean haveLicence) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.haveLicence = haveLicence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHaveLicence() {
		return haveLicence;
	}

	public void setHaveLicence(boolean haveLicence) {
		this.haveLicence = haveLicence;
	}

	@Override
	public String toString() {
		return "Customer id = " + id + ", name = " + name + ", email = " + email + ", age = " + age + ", permis = "
				+ haveLicence;
	}

}
