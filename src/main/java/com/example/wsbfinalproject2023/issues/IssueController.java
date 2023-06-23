package com.example.wsbfinalproject2023.issues;

import com.example.wsbfinalproject2023.projects.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/issues")
public class IssueController {

    private final ProjectRepository projectRepository;
    private final IssueRepository issueRepository;

    public IssueController(ProjectRepository projectRepository, IssueRepository issueRepository) {
        this.projectRepository = projectRepository;
        this.issueRepository = issueRepository;

    }

    @GetMapping
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("issues/index");

        modelAndView.addObject("issue", issueRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("issues/create");

        Issue issue = new Issue();
        modelAndView.addObject("issue", issue);
        modelAndView.addObject("projects", projectRepository.findAll());
        return modelAndView;

    }

    @PostMapping("/save")
    ModelAndView save(@ModelAttribute @Valid Issue issue, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("issues/create");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("issue", issue);
            modelAndView.addObject("projects", projectRepository.findAll());

            return modelAndView;

        }

        issueRepository.save(issue);

        modelAndView.setViewName("redirect:/issues");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("issues/create");

        Issue issue = issueRepository.findById(id).orElse(null);
        modelAndView.addObject("issue", issue);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        issueRepository.deleteById(id);
        return "redirect:/issues";

    }
}