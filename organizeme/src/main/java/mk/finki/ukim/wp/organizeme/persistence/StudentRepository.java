package mk.finki.ukim.wp.organizeme.persistence;
import java.util.List;

import mk.finki.ukim.wp.organizeme.model.*;
public interface StudentRepository {

	 List<Student> getAllStudents();
	 Student GetStudent(String indx);
	 Student AddStudent(Student student);
	 Student DeleteStudent(String indx);
	 Student updateStudent(String indx,String param);
	
	
}
