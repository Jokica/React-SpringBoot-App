package mk.finki.ukim.wp.organizeme.persistence;
import java.util.List;

import mk.finki.ukim.wp.organizeme.model.*;
public interface StudentRepository {

	 List<Student> getAllStudents();
	 Student GetStudent(String indx);
	 Student AddStudent(Student student);
	 Student DeleteStudent(Student student);
	 Student updateStudent(Student student);
	 List<StudyProgram> getAllStudyPrograms();
	 StudyProgram createStudyProgram(StudyProgram studyProgram);
	 StudyProgram deleteStudyProgam(StudyProgram studyProgram);
	StudyProgram getStudyProgam(Long Id);

	
	
}
