package studentdbms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport")
public class Passport 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
	private String number;
	
	@OneToOne(mappedBy = "passport")
	private Student student;
	
	public Passport() {}

	public Passport(String number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
}
