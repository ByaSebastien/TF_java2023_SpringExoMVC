package be.tftic.java.exo.mvc.pl.controller;

import be.tftic.java.exo.mvc.bll.TaskService;
import be.tftic.java.exo.mvc.pl.forms.TaskForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("taskForm",new TaskForm());
        return "task/create";
    }

    @PostMapping("/create")
    public String postCreate(
            @ModelAttribute("taskForm") @Valid TaskForm form,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("taskForm",form);
            return "task/create";
        }
        taskService.create(form.toEntity());
        return "redirect:/task";
    }

    @GetMapping("/update/{id:^[0-9]+$}")
    public String getUpdate(
            @PathVariable long id,
            Model model
    ){
        TaskForm form = TaskForm.fromEntity(taskService.getOne(id));
        model.addAttribute("taskId",id);
        model.addAttribute("taskForm",form);
        return "task/update";
    }

    @PostMapping("/update/{id:^[0-9]+$}")
    public String postUpdate(
            @PathVariable long id,
            @ModelAttribute("taskForm") @Valid TaskForm form,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("taskId",id);
            model.addAttribute("taskForm",form);
            return "task/update";
        }
        taskService.update(id,form.toEntity());
        return "redirect:/task";
    }

    @GetMapping("/delete/{id:^[0-9]+$}")
    public String delete(
            @PathVariable long id
    ){
        taskService.delete(id);
        return "redirect:/task";
    }
}
