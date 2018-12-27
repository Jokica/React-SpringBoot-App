package mk.finki.ukim.wp.organizeme.Rest;

import java.util.List;
import java.util.stream.Collectors;

import mk.finki.ukim.wp.organizeme.StudentService.StudentNotFoundExeption;
import mk.finki.ukim.wp.organizeme.StudentService.StudentProgramNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import mk.finki.ukim.wp.organizeme.model.*;
import mk.finki.ukim.wp.organizeme.StudentService.StudentService;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "localhost:3000"})
@RestController
@RequestMapping(value = "/study_programs",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyProgramController {
    private final StudentService studentService;

    @Autowired
    public StudyProgramController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<StudyProgram> getStudentProgramss(){

        return studentService.getStudyPrograms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody StudyProgram student, HttpServletResponse response)  {
        StudyProgram s = studentService.postStudyProgram(student);
        response.setHeader("Location", "/tasks/" + s.Id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
            throws StudentProgramNotFound {
        studentService.deleteStudyProgram(id);
    }






}
