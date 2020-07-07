package com.testingcenter.model;

/**
 * Model class for single Question from test
 *
 * @author Matveev Alexander
 */
public class TestQuestion {
    private String questionText;
    private Test questionTest;

    /**
     * Constructor of class
     *
     * @param questionText text of question
     * @param questionTest test of this question
     */
    public TestQuestion(String questionText, Test questionTest) {
        this.questionText = questionText;
        this.questionTest = questionTest;
    }

    /**
     * Get test of this question
     *
     * @return test of question
     */
    public Test getQuestionTest() {
        return questionTest;
    }

    /**
     * Method to get text of question
     *
     * @return text of question
     */
    public String getQuestionText() {
        return questionText;
    }
}
