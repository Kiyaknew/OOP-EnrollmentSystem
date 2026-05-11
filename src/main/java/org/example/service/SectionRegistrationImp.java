package org.example.service;

import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SectionRegistrationImp implements SectionRegistration{
    private List<Section> sectionList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void saveSection(Section section){
        for (int i = 0; i < sectionList.size(); i++){
            if (sectionList.get(i).getSectionID().equals(section.getSectionID())) {
                System.out.println("Section ID " + section.getSectionID() + " already exists.");
                return;
            }
        }
        sectionList.add(section);
        System.out.println(section.getSectionName() + " added to the system.");
    }

    public void displayAllSections(){
        System.out.println("---------------------------SECTION LIST---------------------------");
        for (int k = 0; k < sectionList.size(); k++) {
            System.out.println((k + 1) + ". " + sectionList.get(k));

        }
        System.out.println("-------------------------------------------------------------------");

    }

    public void updateSection(Section section){
        for (int i = 0; sectionList.size() > i; i++){
            if (sectionList.get(i).getSectionID().equals(section.getSectionID())){
                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter program: ");
                String program = input.nextLine();

                System.out.print("Current Max Capacity: " + sectionList.get(i).getMaxCapacity() + "\n" + "Enter max capacity: ");
                int capacity = Integer.parseInt(input.nextLine());

                Section updatedSection = new Section(section.getSectionID(), name, capacity, program);

                updatedSection.setAssignedInstructor(sectionList.get(i).getAssignedInstructor());
                updatedSection.setEnrolledList(sectionList.get(i).getEnrolledList());
                sectionList.set(i, updatedSection);
                System.out.println("Section successfully updated.");
                return;

            }
        }

    }

    public void removeSection(String sectionID){
        for(int i = 0; sectionList.size() > i; i++){
            if (sectionList.get(i).getSectionID().equals(sectionID)){
                sectionList.remove(i);
                System.out.println("Successfully deleted");
                return;
            }
        }
        System.out.println("Section does not exist.");
    }

    public Section findSectionByID(String sectionID){
        for(int i = 0; sectionList.size() > i; i++){
            if(sectionList.get(i).getSectionID().equals(sectionID)) {
                return sectionList.get(i);
            }
        }
        return null;
    }
    public List<Section> getSectionList(){
        return sectionList;
    }

}

