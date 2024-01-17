package be.tftic.java.exo.mvc.bll.impl;

import be.tftic.java.exo.mvc.bll.TaskService;
import be.tftic.java.exo.mvc.dal.TaskRepository;
import be.tftic.java.exo.mvc.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getOne(long id) {
        return taskRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
