package org.example.service;

import static org.junit.jupiter.api.Assertions.*;
import org.example.model.Course;
import org.example.service.CourseRegistrationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationImplTest {
    private CourseRegistrationImpl courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseRegistrationImpl();
    }

    @Test
    void testSaveCourse_Success() {
        Course course = new Course("1", "Java Programming", "BSIT", 3);
        courseService.saveCourse(course);
        assertEquals(1, courseService.getCourseList().size());
    }

    @Test
    void testSaveCourse_DuplicateID() {
        Course course1 = new Course("1", "Java Programming", "BSIT", 3);
        Course course2 = new Course("1", "Python Programming", "BSCS", 3);

        courseService.saveCourse(course1);
        courseService.saveCourse(course2);

        assertEquals(1, courseService.getCourseList().size());
    }

    @Test
    void testFindCourseByID_FoundAndNotFound() {
        Course course = new Course("2", "Database Systems", "BSIT", 3);
        courseService.saveCourse(course);

        assertNotNull(courseService.findCourseByID("2"));
        assertNull(courseService.findCourseByID("3"));
    }

    @Test
    void testRemoveCourse_Success() {
        Course course = new Course("1", "Java Programming", "BSIT", 3);
        courseService.saveCourse(course);

        courseService.removeCourse(course);
        assertEquals(0, courseService.getCourseList().size());
    }

    @Test
    void testRemoveCourse_NotFound() {
        Course course = new Course("1", "Java Programming", "BSIT", 3);
        courseService.removeCourse(course);
    }

    @Test
    void testUpdateCourse_NotFound() {
        Course course = new Course("99", "Unknown Course", "None", 0);
        courseService.updateCourse(course);
    }

    @Test
    void testDisplayAllCourse() {
        courseService.saveCourse(new Course("1", "Java Programming", "BSIT", 3));
        courseService.displayAllCourse();
    }
}
