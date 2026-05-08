package org.example.service;

import org.example.model.Section;

public interface SectionRegistration {
    void saveSection(Section section);
    void displayAllSections();
    void updateSection(Section section);
    String removeSection(String sectionID);
    Section findSectionByID(String sectionID);

}
