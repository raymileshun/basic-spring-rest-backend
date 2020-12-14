package hu.spring.backend.service;

import hu.spring.backend.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudents(String query);
    Student getStudentById(long id);
    ResponseEntity<Student> updateStudent(long id, Student student) throws Exception;
    void removeStudent(long id);

}
