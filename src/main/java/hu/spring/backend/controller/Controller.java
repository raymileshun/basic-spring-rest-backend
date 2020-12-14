package hu.spring.backend.controller;

import hu.spring.backend.model.Student;
import hu.spring.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    StudentService studentService;


    @GetMapping("/students")
    List<Student> getAllStudents(@RequestParam(required = false, name = "firstName") String firstName) {
        return studentService.getAllStudents(firstName);
    }

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student newStudent) throws Exception {
        return studentService.updateStudent(id,newStudent);
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable int id){
        studentService.removeStudent(id);
    }
}
