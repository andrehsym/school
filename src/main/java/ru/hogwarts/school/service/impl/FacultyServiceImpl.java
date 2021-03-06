package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class FacultyServiceImpl implements FacultyService {
    Map<Long, Faculty> faculties = new HashMap<>();
    long countFacultyId = 0;

    private Faculty createFaculty(String name, String color) {
        Faculty newFaculty = new Faculty(countFacultyId, name, color);
        faculties.put(countFacultyId, newFaculty);
        ++countFacultyId;
        return newFaculty;
    }

    @Override //POST
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++countFacultyId);
        faculties.put(countFacultyId, faculty);
        return faculty;
    }

    @Override //GET
    public Faculty findFaculty(long id) { //get one student
        return faculties.get(id);
    }

    @Override //GET
    public Map<Long, Faculty> getFacultyCollection() { //get all students
        return faculties;
    }

    @Override //PUT
    public Faculty editFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override //DELETE
    public Faculty removeFaculty(long id) { //remove
        return faculties.remove(id);
    }

    @Override //GET
    public Set<Faculty> filterFacultiesByColor(String color) {
        Set<Faculty> filterFacultiesByColor = new HashSet<>();
        for (Faculty faculty: faculties.values()) {
            if (faculty.getColor().equals(color)) {
                filterFacultiesByColor.add(faculty);
            }
        }
        return filterFacultiesByColor;
    }

    @PostConstruct
    public void init() {
        createFaculty("Gryffindor", "red");
        createFaculty("Hufflepuff", "grey");
        createFaculty("Ravenclaw", "blue");
        createFaculty("Slytherin", "green");
    }
}
