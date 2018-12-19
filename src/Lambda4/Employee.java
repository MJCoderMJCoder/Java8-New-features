package Lambda4;



public class Employee {
	private String name;
	private Integer age;
	private Double salary;
	private Status Status;
	private String office;

	public enum Status{
		FREE,
		BUSY,
		VACATION;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", Status=" + Status + ", office="
				+ office + "]";
	}

	public Employee(String name, Integer age, Double salary, Lambda4.Employee.Status status, String office) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		Status = status;
		this.office = office;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	



	
	
	
	
	
	
	
	

}
