package gr.aueb.cf.springauthsession5.controller;

import gr.aueb.cf.springauthsession5.model.Teacher;
import gr.aueb.cf.springauthsession5.service.ITeacherService;
import gr.aueb.cf.springauthsession5.service.IUserService;
import gr.aueb.cf.springauthsession5.service.exceptions.TeacherAlreadyExistsException;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gr.aueb.cf.springauthsession5.dto.RegisterTeacherDTO;

@Controller
@RequiredArgsConstructor
public class RegisterTeacherController {

    private final IUserService userService;
    private final ITeacherService teacherService;

    @GetMapping("/teachers/register")
    public String login(Model model) {
        model.addAttribute("userForm", new RegisterTeacherDTO());
        return "register";
    }

    @PostMapping("/teachers/register")
    public String registration(@Valid @ModelAttribute("userForm") RegisterTeacherDTO teacherDTO,
                               BindingResult bindingResult) throws TeacherAlreadyExistsException {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            Teacher createdTeacher = teacherService.registerTeacher(teacherDTO);
        } catch (TeacherAlreadyExistsException e) {
            throw e;
        }

        return "redirect:/login";
    }
}