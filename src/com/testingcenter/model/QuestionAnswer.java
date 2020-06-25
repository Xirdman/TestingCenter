package com.testingcenter.model;

/**
 * Class for single answer for test question
 */
public class QuestionAnswer {
    private String text;
    private int points;
    private TestQuestion question;
    private int questionId;

    /**
     * Constructor of class
     *
     * @param text       text of answer
     * @param points     points for chosing this answer
     * @param question   Question of this answer
     * @param questionId Identificator of answer
     */
    public QuestionAnswer(String text, int points, TestQuestion question, int questionId) {
        this.text = text;
        this.points = points;
        this.question = question;
        this.questionId = questionId;
    }

    /**
     * Method to get question of this answer
     *
     * @return
     */
    public TestQuestion getQuestion() {
        return question;
    }

    /**
     * Mathod to get points for choosing this answer
     *
     * @return
     */
    public int getPoints() {
        return points;
    }
}
