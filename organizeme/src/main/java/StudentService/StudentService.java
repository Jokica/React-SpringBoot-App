package StudentService;

import java.util.List;

import mk.finki.ukim.wp.organizeme.model.Student;

public interface StudentService {
	List<Student> getStudents();
	
	Student getStudentById(String index) throws StudentNotFoundExeption;
	
	Student postStudent(Student student);
	Student updateStudent(String index,Student student);
	Student deleteStudent(String index);
}
