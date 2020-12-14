package hu.spring.backend.service;

import hu.spring.backend.model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    StudentServiceImpl studentService = new StudentServiceImpl();

    @Test
    void testWithoutFiltering() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("James","Denim",23));
        studentList.add(new Student("Scarlett","Woods",21));
        String queryParameter="";
        List<Student> filteredList = studentService.filterOutStudents(studentList,queryParameter);
        assertEquals(studentList.size(),filteredList.size());
    }

    @Test
    void allStudentsGotFilteredTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("James","Denim",23));
        studentList.add(new Student("Scarlett","Woods",21));
        String queryParameter="a";
        List<Student> filteredList = studentService.filterOutStudents(studentList,queryParameter);
        assertEquals(studentList.size(),filteredList.size());
    }

    @Test
    void filteredStudentListContainsScarlett() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("James","Denim",23));
        Student testingStudent= new Student("Scarlett","Woods",21);
        studentList.add(testingStudent);
        String queryParameter="sc";
        List<Student> filteredList = studentService.filterOutStudents(studentList,queryParameter);
        assertTrue(filteredList.size()==1 && filteredList.contains(testingStudent));
    }


}