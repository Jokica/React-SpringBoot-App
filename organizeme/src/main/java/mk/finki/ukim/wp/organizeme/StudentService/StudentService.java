package mk.finki.ukim.wp.organizeme.StudentService;

import java.util.List;

import mk.finki.ukim.wp.organizeme.Rest.PostStudentDto;
import mk.finki.ukim.wp.organizeme.Rest.UpdateStudentDto;
import mk.finki.ukim.wp.organizeme.model.Student;
import mk.finki.ukim.wp.organizeme.model.StudyProgram;

public interface StudentService {
	List<Student> getStudents();
	
	Student getStudentById(String index) throws StudentNotFoundExeption;
	
	Student postStudent(PostStudentDto student) throws StudentProgramNotFound;
	Student updateStudent(String index,UpdateStudentDto studentDto)throws StudentNotFoundExeption,StudentProgramNotFound ;
	Student deleteStudent(String index) throws StudentNotFoundExeption;

	List<StudyProgram> getStudyPrograms();
	StudyProgram postStudyProgram(StudyProgram student);
	StudyProgram deleteStudyProgram(Long Id)
			throws  StudentProgramNotFound;

}
