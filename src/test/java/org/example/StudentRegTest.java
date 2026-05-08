package org.example;

import org.example.model.Student;
import org.example.service.StudentRegistrationImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegTest {
    private StudentRegistrationImp testStudentReg;

    @BeforeEach
    void setUp() {
        testStudentReg = new StudentRegistrationImp();
    }

    @Test
    void testUpdateStudent() {
        //Arrange
        testStudentReg.saveStudent(new Student("S01", "Erika Trixie P. Dirilo", 20, "BSIT"));

        //Act
        testStudentReg.updateStudent(new Student("S01", "Nigel Andrei A. Linatoc", 19, "MMA"));

        //Assert
        Student updatedStudent = testStudentReg.findStudentByID("S01");
        assertEquals("Nigel Andrei A. Linatoc", updatedStudent.getName());
        assertEquals("MMA", updatedStudent.getProgram());
    }
}



