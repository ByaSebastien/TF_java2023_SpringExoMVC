package be.tftic.java.exo.mvc.dal.utils;

import be.tftic.java.exo.mvc.dal.TaskRepository;
import be.tftic.java.exo.mvc.domain.Task;
import be.tftic.java.exo.mvc.domain.Urgency;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {

        Task task1 = new Task();
        task1.setTitle("Apprendre Java");
        task1.setDescription("La vie n'en sera que plus 'belle'");
        task1.setUrgency(Urgency.MEDIUM);

        Task task2 = new Task();
        task2.setTitle("Apprendre Angular");
        task2.setDescription("La vie n'en sera que plus 'belle'");
        task2.setUrgency(Urgency.MEDIUM);

        Task task3 = new Task();
        task3.setTitle("Trouver un travail");
        task3.setDescription("Pour vivre à l'américaine");
        task3.setUrgency(Urgency.HIGH);

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
    }
}
