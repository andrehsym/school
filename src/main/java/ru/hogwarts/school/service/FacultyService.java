package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Map;
import java.util.Set;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Map<Long, Faculty> getFacultyCollection();

    Faculty editFaculty(Faculty faculty);

    Faculty removeFaculty(long id);

    Set<Faculty> filterFacultiesByColor(String color);
}
