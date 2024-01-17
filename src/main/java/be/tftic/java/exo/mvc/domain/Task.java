package be.tftic.java.exo.mvc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long id;

    @Column(name = "task_title", nullable = false)
    private String title;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_urgency", nullable = false)
    private Urgency urgency;

    public Task(String title, String description, Urgency urgency) {
        this.title = title;
        this.description = description;
        this.urgency = urgency;
    }
}
