package com.example.springbootstudentcrud.controller;

import com.example.springbootstudentcrud.entity.Guide;
import com.example.springbootstudentcrud.entity.Student;
import com.example.springbootstudentcrud.repository.GuideRepository;
import com.example.springbootstudentcrud.repository.StudentRepository;
import com.example.springbootstudentcrud.repository.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {

    private final StudentRepository student;
    private final GuideRepository guide;
    private final SubjectRepository subjectRepository;


    public StudentController(StudentRepository student, GuideRepository guide, SubjectRepository subjectRepository) {
        this.student = student;
        this.guide = guide;
        this.subjectRepository = subjectRepository;
    }


    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        List<Guide> guides = guide.findAll();
        model.addAttribute("guides", guides);
        model.addAttribute("subjects", subjectRepository.findAll());
        return "addstudent";
    }


    @PostMapping("/addstudent")
    public String addStudent(Student student, BindingResult result, Model model) {

        if (student.getName().equals("") || student.getName().matches(".*\\d+.*")) {
            result.rejectValue("name", "name");
            return "redirect:/addstudent";
        }

        this.student.save(student);
        return "redirect:/allstudents";
    }

    @RequestMapping(value = {"/allstudents", "/"}, method = RequestMethod.GET)
    public String allStudents(ModelMap model) {
        model.put("students", student.findAll());
        model.put("subjects", subjectRepository.findAll());
        return "allstudents";
    }

    @GetMapping("/test")
    public String index(ModelMap model) {
        model.put("students", student.findAll());
        model.put("subjects", subjectRepository.findAll());
        return "index";
    }

    @PostMapping("/addstudent2")
    @ResponseBody
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(this.student.save(student), HttpStatus.OK);
    }

}
