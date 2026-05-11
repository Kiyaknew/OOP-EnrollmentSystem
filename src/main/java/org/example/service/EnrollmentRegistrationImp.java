package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;

public class EnrollmentRegistrationImp implements EnrollmentRegistration {
    private StudentRegistration studentReg;
    private SectionRegistration sectionReg;
    private DepartmentRegistration departmentReg;

    public EnrollmentRegistrationImp(StudentRegistration studentReg, SectionRegistration sectionReg, DepartmentRegistration departmentReg) {
        this.studentReg = studentReg;
        this.sectionReg = sectionReg;
        this.departmentReg = departmentReg;
    }

    public void enrollStudentInSection(String studentID, String sectionID) {
        Student student = studentReg.findStudentByID(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Section section = sectionReg.findSectionByID(sectionID);
        if (section == null) {
            System.out.println("Section not found");
            return;
        }
        for (int i = 0; i < section.getEnrolledList().size(); i++) {
            if (section.getEnrolledList().get(i).getId().equals(studentID)) {
                System.out.println("Student is already enrolled in this section.");
                return;
            }
        }
        if (section.getEnrolledList().size() >= section.getMaxCapacity()) {
            System.out.println("Enrollment REJECTED: Section " + section.getSectionName() +
                    " is already full (" +
                    section.getMaxCapacity() + "/" + section.getMaxCapacity() + ").");
            return;
        }
        section.getEnrolledList().add(student);
        System.out.println("Successfully enrolled " + student.getName() +
                " in " + section.getSectionName() +
                " (" + section.getEnrolledList().size() +
                "/" + section.getMaxCapacity() + ")");
        }

        public void viewDepartmentHierarchy(String departmentID){
            Department dept = departmentReg.findDepartmentByID((departmentID));
            if (dept == null){
                System.out.print("Department not found");
                return;
            }
            System.out.println("\n==========================================");
            System.out.println("DEPARTMENT: " + dept.getDepartmentName() +
                    " (" + dept.getDepId() + ")");
            System.out.println("==========================================");

            if (dept.getSections().isEmpty()) {
                System.out.println("  No sections found.");
                return;
            }
            for(int i =0; i < dept.getSections().size(); i++){
                Section section = dept.getSections().get(i);
                System.out.println("  SECTION   : " + section.getSectionName() +
                        " [" + section.getSectionID() + "]");
                System.out.println("  Program   : " + section.getProgram());
                System.out.println("  Instructor: " +
                        (section.getAssignedInstructor() != null ?
                                section.getAssignedInstructor().getName() : "TBA"));
                System.out.println("  Enrolled  : " +
                        section.getEnrolledList().size() + "/" + section.getMaxCapacity());
                System.out.println("  Students  :");

                if (section.getEnrolledList().isEmpty()) {
                    System.out.println("    (no students enrolled)");
                } else {
                    for (int j = 0; j < section.getEnrolledList().size(); j++) {
                        Student student = section.getEnrolledList().get(j);
                        System.out.println("    - " + student.getName() +
                                " (" + student.getId() + ")");
                    }
                }
                System.out.println("------------------------------------------");  
            }
        }

    }
