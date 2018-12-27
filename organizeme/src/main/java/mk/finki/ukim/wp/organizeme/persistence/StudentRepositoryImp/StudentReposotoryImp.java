package mk.finki.ukim.wp.organizeme.persistence.StudentRepositoryImp;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import mk.finki.ukim.wp.organizeme.model.Student;
import mk.finki.ukim.wp.organizeme.model.StudyProgram;
import mk.finki.ukim.wp.organizeme.persistence.StudentRepository;
@Repository
public class StudentReposotoryImp implements StudentRepository{
	
	private static List<Student> students;
	@PostConstruct
	public void init() {
		StudyProgram sp = new StudyProgram(123L,"Nekoja");
		Student st = new Student("163191","Jovan","Gjorgiev",sp);
		students.add(st);
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public Student GetStudent(String indx) {
		// TODO Auto-generated method stub
		return students.stream()
				.filter(x -> x.index == indx)
				.findFirst()
				.orElse(null);
	}

	@Override
	public Student AddStudent(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public Student DeleteStudent(String indx) {
		 Student sut = GetStudent(indx);
		 students.remove(sut);
		 return sut;
	}

	@Override
	public Student updateStudent(String indx, String param) {
		Student sut = GetStudent(indx);
		return sut;

	}

}
