package mk.finki.ukim.wp.organizeme.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mk.finki.ukim.wp.organizeme.model.*;
import StudentService.StudentService;

@RestController
@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentControler {
	private final StudentService studentService;
	
	@Autowired
	public StudentControler(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

	
}
