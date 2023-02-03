package com.example.wsbfinalproject2023.projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/projects")

public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController (ProjectRepository projectRepository){
        this.projectRepository = projectRepository;

    }

    // TODO: @Secured(ROLE_PROJECTS_TAB)

    @GetMapping
    ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("projects/index");

        modelAndView.addObject("test", "TEST ZMIENNEJ");
        modelAndView.addObject("projects", projectRepository.findAll());

        return modelAndView;

    }


}
