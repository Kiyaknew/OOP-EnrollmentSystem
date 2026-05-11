package org.example.service;

import static org.junit.jupiter.api.Assertions.*;
import org.example.service.SectionRegistrationImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.model.*;

    class SectionRegistrationTest {

        private SectionRegistrationImp sectionService;

        @BeforeEach
        void setUp() {
            sectionService = new SectionRegistrationImp();
        }

        @Test
        void testSaveSection_Success() {
            Section section = new Section("1", "Java Programming", 30, "BSIT");
            sectionService.saveSection(section);
            assertEquals(1, sectionService.getSectionList().size());
        }

        @Test
        void testSaveSection_DuplicateID() {
            Section section1 = new Section("1", "Java Programming", 30, "BSIT");
            Section section2 = new Section("1", "Web Development", 25, "BSCS");

            sectionService.saveSection(section1);
            sectionService.saveSection(section2);

            assertEquals(1, sectionService.getSectionList().size());
        }

        @Test
        void testFindSectionByID_FoundAndNotFound() {
            Section section = new Section("2", "Database Design", 40, "BSIS");
            sectionService.saveSection(section);

            assertNotNull(sectionService.findSectionByID("2"));
            assertNull(sectionService.findSectionByID("3"));
        }

        @Test
        void testRemoveSection_Success() {
            Section section = new Section("1", "Java Programming", 30, "BSIT");
            sectionService.saveSection(section);

            sectionService.removeSection("1");
            assertEquals(0, sectionService.getSectionList().size());
        }

        @Test
        void testRemoveSection_NotFound() {
            sectionService.removeSection("99");
        }

        @Test
        void testUpdateSection_NotFound() {
            Section section = new Section("99", "Ghost Section", 0, "None");
            sectionService.updateSection(section);
        }

        @Test
        void testDisplayAllSections() {
            sectionService.saveSection(new Section("1", "Java Programming", 30, "BSIT"));
            sectionService.displayAllSections();
        }
    }