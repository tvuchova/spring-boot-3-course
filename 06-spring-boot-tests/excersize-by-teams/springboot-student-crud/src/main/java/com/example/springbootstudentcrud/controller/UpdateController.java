package com.example.springbootstudentcrud.controller;

import com.example.springbootstudentcrud.entity.Guide;
import com.example.springbootstudentcrud.entity.Student;
import com.example.springbootstudentcrud.repository.GuideRepository;
import com.example.springbootstudentcrud.repository.StudentRepository;
import com.example.springbootstudentcrud.repository.SubjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


@Controller
@RequestMapping("/students/{studentId}")
public class UpdateController {

    private final StudentRepository studentRepository;
    private final GuideRepository guideRepository;
    private final SubjectRepository subjectRepository;


    public UpdateController(StudentRepository studentRepository, GuideRepository guideRepository,
                            SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.guideRepository = guideRepository;
        this.subjectRepository = subjectRepository;
    }

    @ModelAttribute("student")
    public Optional<Student> findStudent(@PathVariable("studentId") int studentId) {
        return this.studentRepository.findById(studentId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGuide(ModelMap model) {
        model.put("guides", guideRepository.findAll());
        model.put("subjects", subjectRepository.findAll());

        return "test";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGuide(Student student, Guide guide, ModelMap model) {
        this.studentRepository.save(student);
        return "redirect:/allstudents";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudent(Student student, ModelMap model) {
        this.studentRepository.delete(student);
        return "redirect:/allstudents";
    }


}
