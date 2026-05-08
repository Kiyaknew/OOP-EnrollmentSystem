package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentRegistrationImp implements DepartmentRegistration {
    private List<Department> departmentList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void saveDepartment(Department department){
        departmentList.add(department);
        System.out.println(department.getDepartmentName() + " added to the system.");
    }

    public void displayAllDepartment() {
        System.out.println("---------------------------DEPARTMENT LIST---------------------------");
        for (int k = 0; k < departmentList.size(); k++) {
            System.out.println((k + 1) + ". " + departmentList.get(k));

        }
        System.out.println("-------------------------------------------------------------------");
    }
    
    public void updateDepartment(Department department){
        for (int i = 0; departmentList.size() > i; i++){
            if (departmentList.get(i).getDepId().equals(department.getDepId())){
                System.out.print("Enter name: ");
                String name = input.nextLine();

                Department updatedDep = new Department(department.getDepId(), name);

                updatedDep.setSections(departmentList.get(i).getSections());
                departmentList.set(i, updatedDep);
                return;
            }
        }
    }

    public void removeDepartment(String departmentID){
        for (int i = 0; departmentList.size() > i; i++) {
            if (departmentList.get(i).getDepId().equals(departmentID)) {
                departmentList.remove(i);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void addSectiontoDepartment(String departmentID, Section section){
        Department assignDep = findDepartmentByID(departmentID);
        if (assignDep == null){
            System.out.println("Department not found.");
            return;
        }
        assignDep.getSections().add(section);
    }

    public void removeSectionFromDepartment(String departmentID, String sectionID) {
        Department removeSectionDepartment = findDepartmentByID(departmentID);
        if (removeSectionDepartment == null) {
            System.out.println("Department not found");
            return;
        }
        for (int i = 0; removeSectionDepartment.getSections().size() > i; i++) {
            if (removeSectionDepartment.getSections().get(i).getSectionID().equals(sectionID)) {
                removeSectionDepartment.getSections().remove(i);
                System.out.println("Removed the section from department.");
                return;
            }
        }
    }

    public Department findDepartmentByID(String departmentID){
        for (int i = 0; departmentList.size() > i; i++) {
            if (departmentList.get(i).getDepId().equals(departmentID)){
                return departmentList.get(i);
            }
        }
     return null;

    }

}
