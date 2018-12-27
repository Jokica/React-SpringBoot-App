package mk.finki.ukim.wp.organizeme.Rest;

import java.util.List;
import java.util.stream.Collectors;

import mk.finki.ukim.wp.organizeme.StudentService.StudentNotFoundExeption;
import mk.finki.ukim.wp.organizeme.StudentService.StudentProgramNotFound;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import mk.finki.ukim.wp.organizeme.model.*;
import mk.finki.ukim.wp.organizeme.StudentService.StudentService;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "localhost:3000"})
@RestController
@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentControler {
	private final StudentService studentService;
	
	@Autowired
	public StudentControler(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping
	public List<Student> getStudents(){

		return studentService.getStudents();
	}
	@GetMapping("/by_study_program/{Id}")
	public  List<Student> getStudentsBySP(@PathVariable("Id") Long Id)  {
		return studentService.getStudents()
							  	.stream()
								.filter(x->x.studyProgram.Id.equals(Id))
								.collect(Collectors.toList());
	}
	@PatchMapping("/{index}")
	public void updateStudent(@PathVariable("index") String index,@RequestBody UpdateStudentDto studentDto,HttpServletResponse response){
		try{
			studentService.updateStudent(index,studentDto);
		}
		catch (StudentNotFoundExeption studentNotFoundExeption){
			response.setStatus(404);
		}
		catch (StudentProgramNotFound studentProgramNotFound){
			response.setStatus(400);
		}

	}
	@GetMapping("/{index}")
	public Student getStudentsById(@PathVariable("index") String index)
			throws StudentNotFoundExeption {
		return  studentService.getStudentById(index);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addNew(@RequestBody PostStudentDto student, HttpServletResponse response)
	throws  StudentProgramNotFound{
		Student s = studentService.postStudent(student);
		response.setHeader("Location", "/tasks/" + s.index);
	}
	@DeleteMapping("/{index}")
	public void delete(@PathVariable String index)
	throws  StudentNotFoundExeption{
		 studentService.deleteStudent(index);
	}






}
