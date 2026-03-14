package com.klu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return new ResponseEntity<>("Title cannot be empty", HttpStatus.BAD_REQUEST);
        }

        Course savedCourse = service.addCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {

        Optional<Course> course = service.getCourseById(id);

        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {

        Optional<Course> existing = service.getCourseById(id);

        if (existing.isPresent()) {
            Course updated = service.updateCourse(id, course);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {

        Optional<Course> existing = service.getCourseById(id);

        if (existing.isPresent()) {
            service.deleteCourse(id);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        if (courses.isEmpty()) {
            return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}