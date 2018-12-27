package StudentService;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.finki.ukim.wp.organizeme.model.Student;
import mk.finki.ukim.wp.organizeme.persistence.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	private final StudentRepository repo;
	public StudentServiceImp(StudentRepository repo) {
		this.repo=repo;
	}
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return repo.getAllStudents();
	}

	@Override
	public Student getStudentById(String index) throws StudentNotFoundExeption {
		// TODO Auto-generated method stub
		Student s = repo.GetStudent(index);
		if(s == null)
			throw new StudentNotFoundExeption();
		return s;
	}

	@Override
	public Student postStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.AddStudent(student);
	}

	@Override
	public Student updateStudent(String index, Student student) {
		// TODO Auto-generated method stub
		return repo.updateStudent(index, );
	}

	@Override
	public Student deleteStudent(String index) {
		// TODO Auto-generated method stub
		return repo.DeleteStudent(index);
	}

}
