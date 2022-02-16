package cs5220stu14.hw1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String name; // assuming unique names as per Canvas instructions
	
	@Column(name = "birth_year")
	private Integer birthYr;
	
	@ManyToOne
	@JoinColumn(name = "student_group_name")
	private StudentGroup studentGroup;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getBirthYr() {
		return birthYr;
	}
	public void setBirthYr(Integer birthYr) {
		this.birthYr = birthYr;
	}
	
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	
	public String toString() {
		return this.name + ", " + this.birthYr;
	}
}
