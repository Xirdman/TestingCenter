package com.testingcenter.controller;

import com.testingcenter.model.QuestionAnswer;
import com.testingcenter.model.TestQuestion;

import java.util.List;

/**
 * Class to work with test question
 *
 * @author Matveev Alexander
 */
public class TestQuestionController {
    /**
     * Method to get maximum points for single question
     *
     * @param question question to get points
     * @return maximum points for question
     */
    public int getQuestionMaxPoints(TestQuestion question) {
        int points = 0;
        List<QuestionAnswer> list = Repository.getQuestionAnswers();
        for (QuestionAnswer questionAnswer : list) {
            if (questionAnswer.getQuestion() == question) {
                points += questionAnswer.getPoints();
            }
        }
        return points;
    }
}
