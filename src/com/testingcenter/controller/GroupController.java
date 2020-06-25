package com.testingcenter.controller;

import com.testingcenter.model.Group;
import com.testingcenter.model.Student;
import com.testingcenter.model.StudentRatingDto;
import com.testingcenter.model.User;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to make business logic with Student user
 */
public class GroupController {
    public List<Student> getStudentsByGroup(int groupId) {
        List<Student> studentsList = new LinkedList<>();
        List<User> list = Repository.getUsers();
        Iterator<User> userIterator = list.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user instanceof Student) {
                if (((Student) user).getGroupId() == groupId) {
                    studentsList.add((Student) user);
                }
            }
        }
        return studentsList;
    }

    /**
     * Method to get all raiting of students in group
     *
     * @param groupId identificator number of group
     * @return List of data tranfer objects with Srudent and his raiting
     */
    public List<StudentRatingDto> getGroupRaitings(int groupId) {
        List<StudentRatingDto> studentsRaitings = new LinkedList<>();
        List<Student> students = new GroupController().getStudentsByGroup(groupId);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            studentsRaitings.add(new StudentRatingDto(student,
                    new StudentContoller().getRaiting(student)));
        }
        Collections.sort(studentsRaitings,
                (a, b) -> a.getRating() > b.getRating() ? -1 : a.getRating() == b.getRating() ? 0 : 1);
        return studentsRaitings;
    }

    /**
     * Method to check if group with such group id exists
     *
     * @param groupId group id to check exist or not
     * @return true if group exist false if not
     */
    public boolean isGroupExists(int groupId) {
        List<Group> groups = Repository.getGroups();
        Iterator<Group> iterator = groups.iterator();
        while (iterator.hasNext()) {
            Group group = iterator.next();
            if (group.getId() == groupId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get groups
     *
     * @return List of Groups
     */
    public List<Group> getGroups() {
        return Repository.getGroups();
    }
}
