package com.testingcenter.model;

/**
 * Class for transfer data of student raiting
 */
public class StudentRatingDto {
    private double rating;
    private Student student;

    /**
     * Constructor of dto class
     *
     * @param student student to transfer
     * @param rating  raiting to transfer
     */
    public StudentRatingDto(Student student, double rating) {
        this.rating = rating;
        this.student = student;
    }

    /**
     * Method get student raiting
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     * Method to get Student from dto
     *
     * @return student raiting
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Method to set student to dto
     *
     * @param student student to dto
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
