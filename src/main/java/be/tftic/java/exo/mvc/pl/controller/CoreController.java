package be.tftic.java.exo.mvc.pl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class CoreController {

    @GetMapping({
            "",
            "index",
            "index.html"
    })
    public String home(Model model){
        model.addAttribute("date", LocalDate.now());
        return "core/index";
    }

}
