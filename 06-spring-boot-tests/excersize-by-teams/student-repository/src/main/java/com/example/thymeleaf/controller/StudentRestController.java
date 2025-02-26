package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.CreateStudentDTO;
import com.example.thymeleaf.dto.StudentResponseDTO;
import com.example.thymeleaf.dto.UpdateStudentDTO;
import com.example.thymeleaf.dto.mapper.StudentMapper;
import com.example.thymeleaf.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        List<StudentResponseDTO> students = StudentMapper.toDTO(studentService.findAll());
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody @Valid CreateStudentDTO studentDTO) {
        var student = studentService.save(StudentMapper.toEntity(studentDTO));
        return ResponseEntity.ok(StudentMapper.toDTO(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable String id) {
        var student = studentService.findById(id);
        return ResponseEntity.ok(StudentMapper.toDTO(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable String id, @RequestBody @Valid UpdateStudentDTO studentDTO) {
        var updatedStudent = studentService.update(id, StudentMapper.toEntity(studentDTO));
        return ResponseEntity.ok(StudentMapper.toDTO(updatedStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
