package org.example;

import package org.example.model.Student;
import package  org.example.service.StudentRegistrationImp;
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
        studentReg.saveStudent(new Student("S01", "Erika Trixie P. Dirilo", 20, "BSIT"));

        //Act
        studentReg.updateStudent(new Student("S01", "Nigel Andrei A. Linatoc", 19, "MMA"));

        //Assert
        Student newStudent = testStudentReg
        asserEquals("Nigel Andrei A. Linatoc", )
    }
}



