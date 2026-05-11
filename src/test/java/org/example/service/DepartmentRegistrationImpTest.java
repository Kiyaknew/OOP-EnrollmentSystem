package org.example.service;

import static org.junit.jupiter.api.Assertions.*;
import org.example.model.Department;
import org.example.model.Section;
import org.example.service.DepartmentRegistrationImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentRegistrationImpTest {
    private DepartmentRegistrationImp departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentRegistrationImp();
    }

    @Test
    void testSaveDepartment_Success() {
        Department dept = new Department("1", "College of Engineering");
        departmentService.saveDepartment(dept);
        assertEquals(1, departmentService.getDepartmentList().size());
    }

    @Test
    void testSaveDepartment_DuplicateID() {
        Department dept1 = new Department("1", "College of Engineering");
        Department dept2 = new Department("1", "College of Science");

        departmentService.saveDepartment(dept1);
        departmentService.saveDepartment(dept2);

        assertEquals(1, departmentService.getDepartmentList().size());
    }

    @Test
    void testFindDepartmentByID_FoundAndNotFound() {
        Department dept = new Department("2", "College of Arts");
        departmentService.saveDepartment(dept);

        assertNotNull(departmentService.findDepartmentByID("2"));
        assertNull(departmentService.findDepartmentByID("3"));
    }

    @Test
    void testRemoveDepartment_Success() {
        Department dept = new Department("1", "College of Engineering");
        departmentService.saveDepartment(dept);

        departmentService.removeDepartment("1");
        assertEquals(0, departmentService.getDepartmentList().size());
    }

    @Test
    void testRemoveDepartment_NotFound() {
        departmentService.removeDepartment("99");
    }

    @Test
    void testUpdateDepartment_NotFound() {
        Department dept = new Department("99", "Unknown Dept");
        departmentService.updateDepartment(dept);
    }

    @Test
    void testSectionManagement() {
        Department dept = new Department("1", "CS Department");
        departmentService.saveDepartment(dept);

        Section section = new Section("S1", "Java 101", 30, "MMA");

        departmentService.addSectiontoDepartment("1", section);
        assertFalse(dept.getSections().isEmpty());

        departmentService.removeSectionFromDepartment("1", "S1");
        assertTrue(dept.getSections().isEmpty());

        departmentService.addSectiontoDepartment("99", section);
        departmentService.removeSectionFromDepartment("99", "S1");
    }

    @Test
    void testDisplayAllDepartment() {
        departmentService.saveDepartment(new Department("1", "College of Engineering"));
        departmentService.displayAllDepartment();
    }
}