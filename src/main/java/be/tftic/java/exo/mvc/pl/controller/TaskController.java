package be.tftic.java.exo.mvc.pl.controller;

import be.tftic.java.exo.mvc.bll.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("tasks",taskService.getAll());
        return "task/list";
    }

    @GetMapping("/{id:^[0-9]+$}")
    public String getOne(Model model, @PathVariable long id){
        model.addAttribute("task", taskService.getOne(id));
        return "task/details";
    }
}
