package org.example.service;

import org.example.model.Instructor;
import org.example.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentRegistrationImp implements DepartmentReg{
    static Scanner input = new Scanner(System.in);
    private ArrayList<Department> departmentList = new ArrayList<>();
    List<Instructor> instructors = new ArrayList<>();

    public void saveDepartment(Department department){
        departmentList.add(department);
    }

    public void displayAllDepartment(){
        System.out.println(departmentList);
    }

    public void updateDepartment(Department department){
        for(int i = 0; i<departmentList.size(); i++){
            if(departmentList.get(i).getdepId().equals(department.getdepId())){
                System.out.println("Enter Department Name: ");
                String depName = input.nextLine();

                System.out.println("----------------------------------------------");
                System.out.println("Enter instructor:");
                String instructor = input.nextLine();



                departmentList.set(i, new Department(department.getdepId(), depName, instructors ));
                break;
            }
        }
    }

    public String removeDepartment(Department department){
        departmentList.remove(department);
        return "Successfully deleted department";
    }
}
