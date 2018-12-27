package mk.finki.ukim.wp.organizeme.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Size(min=6,max = 6)
	@Id
	public String index;
	public String name;
	public String lastName;
	@ManyToOne
	public StudyProgram studyProgram;
	public Student(String index, String name, String lastName, StudyProgram studyProgram) {
		super();
		this.index = index;
		this.name = name;
		this.lastName = lastName;
		this.studyProgram = studyProgram;
	}



}
