package com.testingcenter.model;

/**
 * Class for single answer for test question
 */
public class QuestionAnswer {
    private String text;
    private boolean isCorrect;

    /**
     * Constructor for test question answer
     *
     * @param text      Text of answer
     * @param isCorrect is this answer correct or not
     */
    public QuestionAnswer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }
}
