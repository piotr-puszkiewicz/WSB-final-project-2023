package com.example.wsbfinalproject2023.projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping ("/projects")

public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController (ProjectRepository projectRepository){
        this.projectRepository = projectRepository;

    }


    @Controller
    @RequestMapping("/")
    public static class IndexController{
        @GetMapping("/")
        String index() {
            return "projects/index";
        }
    }

    // TODO: @Secured(ROLE_PROJECTS_TAB)



    @GetMapping
    ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("projects/index");

        modelAndView.addObject("test", "TEST ZMIENNEJ");
        modelAndView.addObject("projects", projectRepository.findAll());
        modelAndView.addObject("students", projectRepository.findAll());

        return modelAndView;

    }
  
    @GetMapping ("/create")
    ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("projects/create");

        Project project = new Project();
        modelAndView.addObject("project", project);
        return modelAndView;

    }

    @PostMapping  ("/save")
    String save(@ModelAttribute Project project) {

        projectRepository.save(project);

        return  "redirect:/projects";
    }

}

