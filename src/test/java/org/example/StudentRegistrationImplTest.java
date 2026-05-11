package org.example;

import org.example.model.Student;
import org.example.service.StudentRegistrationImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistrationImplTest {
    private StudentRegistrationImp testStudentReg;

    private StudentRegistrationImp studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentRegistrationImp();
    }

    @Test
    void testSaveStudent_Success() {
        Student student = new Student("1", "Amari", 20, "BSIT");
        studentService.saveStudent(student);
        assertEquals(1, studentService.getStudentList().size());
    }

    @Test
    void testSaveStudent_DuplicateID() {
        Student student1 = new Student("1", "Amari", 20, "BSIT");
        Student student2 = new Student("1", "Nigel", 22, "BSCS");

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        assertEquals(1, studentService.getStudentList().size());
    }

    @Test
    void testFindStudentByID_FoundAndNotFound() {
        Student student = new Student("2", "Nigel", 22, "BSCS");
        studentService.saveStudent(student);

        assertNotNull(studentService.findStudentByID("2"));
        assertNull(studentService.findStudentByID("3"));
    }

    @Test
    void testRemoveStudent_Success() {
        Student student = new Student("1", "Amari", 20, "BSIT");
        studentService.saveStudent(student);

        studentService.removeStudent(student);
        assertEquals(0, studentService.getStudentList().size());
    }

    @Test
    void testRemoveStudent_NotFound() {
        Student student = new Student("1", "Amari", 20, "BSIT");
        studentService.removeStudent(student);
    }

    @Test
    void testUpdateStudent_NotFound() {
        Student student = new Student("99", "Unknown", 0, "None");
        studentService.updateStudent(student);
    }

    @Test
    void testDisplayAllStudent() {
        studentService.saveStudent(new Student("1", "Nigel", 20, "BSIT"));
        studentService.displayAllStudent();
    }
}



