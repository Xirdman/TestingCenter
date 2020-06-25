package com.testingcenter.model;

/**
 * Model class for single Question from test
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
}
