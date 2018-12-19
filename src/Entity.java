
public class Entity {
	private String name;
	private Integer agel;
	private Double salary;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAgel() {
		return agel;
	}
	public void setAgel(Integer agel) {
		this.agel = agel;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Entity(String name, Integer agel, Double salary) {
		super();
		this.name = name;
		this.agel = agel;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Entity [name=" + name + ", agel=" + agel + ", salary=" + salary + "]";
	}
	
	
	
	

}
