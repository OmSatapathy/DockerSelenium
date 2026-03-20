package pojo;

public class Employee {

	private String name;
	private int age;
	private String dept;
	private Student data;
	
	public Employee(String name, int age, String dept, Student data) {
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getDept() {
		return dept;
	}
	public Student getData() {
		return data;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setData(Student data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", dept=" + dept + ", data=" + data + "]";
	}
	
	
}
