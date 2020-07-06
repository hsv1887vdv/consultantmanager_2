package com.akra.consultantmanager.controllers;



import com.akra.consultantmanager.entities.Consultant;
import com.akra.consultantmanager.repositories.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultantController {

    private final ConsultantRepository consultantRepository;

    @Autowired
    public ConsultantController(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @GetMapping("/new")
    public String showSignUpForm(Consultant consultant) {
        return "add-consultant";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Consultant consultant = consultantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid consultant Id:" + id));
        model.addAttribute("consultant", consultant);
        return "update-consultant";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Consultant consultant = consultantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid consultant Id:" + id));
        consultantRepository.delete(consultant);
        model.addAttribute("consultants", consultantRepository.findAll());
        return "index";
    }

    @PostMapping("/addconsultant")
    public String addUser(Consultant consultant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-consultant";
        }

        consultantRepository.save(consultant);
        model.addAttribute("consultants", consultantRepository.findAll());

        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Consultant consultant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            consultant.setId(id);
            return "update-consultant";
        }

        consultantRepository.save(consultant);
        model.addAttribute("consultants", consultantRepository.findAll());
        return "index";
    }
}