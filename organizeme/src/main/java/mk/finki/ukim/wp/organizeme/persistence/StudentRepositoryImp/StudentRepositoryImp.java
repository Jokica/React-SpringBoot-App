package mk.finki.ukim.wp.organizeme.persistence.StudentRepositoryImp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Null;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import mk.finki.ukim.wp.organizeme.model.Student;
import mk.finki.ukim.wp.organizeme.model.StudyProgram;
import mk.finki.ukim.wp.organizeme.persistence.StudentRepository;
@Profile("in-memory-db")
@Repository
public class StudentRepositoryImp implements StudentRepository{
	
	private static List<Student> students
			=new ArrayList<>();
	private static List<StudyProgram> studyPrograms
			=new ArrayList<>();
	@PostConstruct
	public void init() {
		StudyProgram sp = new StudyProgram("Objektno");
		sp.Id = 1L;
		StudyProgram sp2 = new StudyProgram("Napredno");
		sp2.Id = 2L;

		Student st = new Student("163191","Jovan","Gjorgiev",sp);
		Student st2 = new Student("163192","Vesna","Dejanovska",sp2);

		students = Stream.of(st,st2).collect(Collectors.toList());
		studyPrograms = Stream.of(sp,sp2).collect(Collectors.toList());
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
				.filter(x -> x.index.equals(indx))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Student AddStudent(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public Student DeleteStudent(Student student) {
		 students.remove(student);
		 return student;
	}

	@Override
	public Student updateStudent(Student studentToBeUpdated) {
		Student student = GetStudent(studentToBeUpdated.index);
		student = studentToBeUpdated;
		return  student;
	}

	@Override
	public List<StudyProgram> getAllStudyPrograms() {
		return studyPrograms;
	}

	@Override
	public StudyProgram createStudyProgram(StudyProgram studyProgram) {
		studyPrograms.add(studyProgram);
		return  studyProgram;
	}

	@Override
	public StudyProgram deleteStudyProgam(StudyProgram studyProgram) {
		studyPrograms.remove(studyProgram);
		return  studyProgram;
	}

	@Override
	public StudyProgram getStudyProgam(Long Id) {
	return 	studyPrograms.stream()
					.filter(x->x.Id.equals(Id))
					.findFirst()
					.orElse(null);
	}

}
