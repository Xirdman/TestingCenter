package com.testingcenter.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Model class for single Question from test
 */
public class TestQuestion {
    private String questionText;
    private Test questionTest;
    private List<QuestionAnswer> answers;

    /**
     * Constructor for single Question in test
     *
     * @param questionText           Text of question
     * @param questionTest           Test of Question
     * @param answers                Array of answer
     * @param correctAnswerPossition index of correct answer in answers array
     */
    public TestQuestion(String questionText, Test questionTest, String[] answers, int correctAnswerPossition) {
        this.questionText = questionText;
        this.questionTest = questionTest;
        this.answers = new LinkedList<QuestionAnswer>();
        for (int i = 0; i < answers.length; i++) {
            this.answers.add(new QuestionAnswer(answers[i], i == correctAnswerPossition));
        }
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