package org.example.service;

import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SectionRegistrationImp implements SectionRegistration{
    private List<Section> sectionList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void saveSection(Section section){
        sectionList.add(section);
        System.out.println(section.getSectionName() + "added to the system.");

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
                int capacity = input.nextInt();

                Section updatedSection = new Section(section.getSectionID(), name, capacity, program);

                updatedSection.setAssignedInstructor(sectionList.get(i).getAssignedInstructor());
                updatedSection.setEnrolledList(sectionList.get(i).getEnrolledList());

                sectionList.set(i, updatedSection);
                return;

            }
        }

    }

    public String removeSection(String sectionID){
        for(int i = 0; sectionList.size() > i; i++){
            if (sectionList.get(i).getSectionID().equals(sectionID)){
                sectionList.remove(i);
            }
        }
        return "Section not found.";
    }

    public Section findSectionByID(String sectionID){
        for(int i = 0; sectionList.size() > i; i++){
            if(sectionList.get(i).getSectionID().equals(sectionID)) {
                return sectionList.get(i);
            }
        }
        return null;
    }

}

