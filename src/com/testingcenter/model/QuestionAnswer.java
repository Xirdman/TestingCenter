package com.testingcenter.model;

/**
 * Class represent single answer for test question
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
     * @return return question of this answer
     */
    public TestQuestion getQuestion() {
        return question;
    }

    /**
     * Method to get points for choosing this answer
     *
     * @return method returns points for choosing this as answer
     */
    public int getPoints() {
        return points;
    }
}
