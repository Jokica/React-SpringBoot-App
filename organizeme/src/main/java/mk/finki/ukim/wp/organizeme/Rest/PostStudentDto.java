package mk.finki.ukim.wp.organizeme.Rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostStudentDto {
    @NotNull
    public String name;
    @NotNull
    public String lastName;
    @NotNull
    @Size(min=6,max = 6)
    public String index;
    @NotNull
    public String ProgramName;
}
