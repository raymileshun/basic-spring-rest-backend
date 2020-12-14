package hu.spring.backend.service;

import hu.spring.backend.exceptions.StudentNotFoundException;
import hu.spring.backend.model.Student;
import hu.spring.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(String query) {
        List<Student> students = studentRepository.findAll();
        return filterOutStudents(students,query);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()) throw new StudentNotFoundException("Student with this ID not found: "+id);
        return student.get();
    }

    @Override
    public ResponseEntity<Student> updateStudent(long id, Student newStudent) throws Exception {
        Student student = getStudentById(id);

        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setAge(newStudent.getAge());
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @Override
    public void removeStudent(long id) {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

    public List<Student> filterOutStudents(List<Student> students,String query){
        if(query==null){
            return students;
        }

        List<Student> filteredStudents=new ArrayList<>();

        for (Student student: students) {
            String firstName=student.getFirstName().toUpperCase();
            if(firstName.contains(query.toUpperCase())){
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }


}
