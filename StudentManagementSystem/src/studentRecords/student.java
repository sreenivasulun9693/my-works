package studentRecords;

public class student {
	private int student_ID;
	private String name;
	private int age;
	private String grade;
	student(String name,int age,String grade){
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	student(int student_ID,String name,int age,String grade){
		this(name,age,grade);
		this.student_ID=student_ID;	
	}
	public void displayStudent() {
		System.out.println("Name :"+name+"\nAge :"+age+"\nGrade :"+grade);
	}
	
	public int getStudent_ID() {
		return student_ID;
	}
	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
