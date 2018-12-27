package mk.finki.ukim.wp.organizeme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class StudyProgram {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Long Id;
	public String name;
	public StudyProgram( String name) {

		this.name = name;
	}
}
