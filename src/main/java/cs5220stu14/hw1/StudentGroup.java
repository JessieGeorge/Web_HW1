package cs5220stu14.hw1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_groups")
public class StudentGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name; // assuming unique names as per Canvas instructions
	
	@OneToMany(mappedBy = "studentGroup")
	private List<Student> students = new ArrayList<Student>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public String toString() {
		return this.name;
	}
}
