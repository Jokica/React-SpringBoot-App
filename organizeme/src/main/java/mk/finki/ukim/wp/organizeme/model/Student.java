package mk.finki.ukim.wp.organizeme.model;

public class Student {
public String index;
public String name;
public String lastName;
public StudyProgram studyProgram;
public Student(String index, String name, String lastName, StudyProgram studyProgram) {
	super();
	this.index = index;
	this.name = name;
	this.lastName = lastName;
	this.studyProgram = studyProgram;
}
}
