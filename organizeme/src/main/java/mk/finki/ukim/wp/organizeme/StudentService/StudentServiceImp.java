package mk.finki.ukim.wp.organizeme.StudentService;

import java.util.List;

import mk.finki.ukim.wp.organizeme.Rest.PostStudentDto;
import mk.finki.ukim.wp.organizeme.Rest.UpdateStudentDto;
import mk.finki.ukim.wp.organizeme.model.StudyProgram;
import org.springframework.stereotype.Service;

import mk.finki.ukim.wp.organizeme.model.Student;
import mk.finki.ukim.wp.organizeme.persistence.StudentRepository;

@Service
	public class StudentServiceImp implements StudentService {

	private final StudentRepository repo;

	public StudentServiceImp(StudentRepository repo) {
		this.repo = repo;
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
		if (s == null)
			throw new StudentNotFoundExeption();
		return s;
	}

	@Override
	public Student postStudent(PostStudentDto student) throws StudentProgramNotFound {
		StudyProgram sp = repo.getAllStudyPrograms()
							.stream()
							.filter(x->x.name.equalsIgnoreCase(student.ProgramName))
							.findFirst()
							.orElse(null);
		if (sp == null){
			throw  new StudentProgramNotFound();
		}
		Student newStudent = new Student(
				student.index,
				student.name,
				student.lastName,
				sp
		);
		return repo.AddStudent(newStudent);
	}



	@Override
	public Student updateStudent(String index ,UpdateStudentDto studentDto) throws StudentNotFoundExeption, StudentProgramNotFound {
			Student s = repo.GetStudent(index);
			if(s == null){
				throw new StudentNotFoundExeption();
			}
		StudyProgram studentProgram = null;
		if (studentDto.IdOfStudentProgram.isPresent()){
			studentProgram = repo.getStudyProgam(studentDto.IdOfStudentProgram.get());
			}

			if(studentProgram == null){
				throw new StudentProgramNotFound();
			}
			s.studyProgram = studentProgram;
			if(studentDto.Name.isPresent()){
				s.name = studentDto.Name.get();
			}
			if(studentDto.LastName.isPresent()){
				s.lastName = studentDto.LastName.get();
			}
	return 	repo.updateStudent(s);
	}

	@Override
	public Student deleteStudent(String index) throws StudentNotFoundExeption {
		Student student = repo.GetStudent(index);
		if(student != null )
			return repo.DeleteStudent(student);
		throw new StudentNotFoundExeption();
	}

	@Override
	public List<StudyProgram> getStudyPrograms() {
		return	repo.getAllStudyPrograms();
	}

	@Override
	public StudyProgram postStudyProgram(StudyProgram student) {
	return 	repo.createStudyProgram(student);
	}

	@Override
	public StudyProgram deleteStudyProgram(Long Id) throws StudentProgramNotFound {
		StudyProgram sp = repo.getStudyProgam(Id);
		if (sp != null)
			return 	repo.deleteStudyProgam(sp);
		throw new StudentProgramNotFound();
	}

}
