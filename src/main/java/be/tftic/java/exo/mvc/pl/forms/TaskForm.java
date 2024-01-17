package be.tftic.java.exo.mvc.pl.forms;

import be.tftic.java.exo.mvc.domain.Task;
import be.tftic.java.exo.mvc.domain.Urgency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskForm {

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    private String urgency;

    public Task toEntity(){
        return new Task(this.title,this.description,Enum.valueOf(Urgency.class,this.urgency));
    }

    public static TaskForm fromEntity(Task t){
        return new TaskForm(t.getTitle(),t.getDescription(),t.getUrgency().toString());
    }
}
