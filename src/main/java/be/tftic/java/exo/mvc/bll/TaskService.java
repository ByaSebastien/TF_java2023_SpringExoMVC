package be.tftic.java.exo.mvc.bll;

import be.tftic.java.exo.mvc.domain.Task;

import java.util.List;

public interface TaskService {

    Task getOne(long id);
    List<Task> getAll();
}
