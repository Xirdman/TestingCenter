package com.testingcenter.controller;

import com.testingcenter.model.QuestionAnswer;
import com.testingcenter.model.TestQuestion;

import java.util.Iterator;
import java.util.List;

/**
 * Class to work with test question
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
        Iterator<QuestionAnswer> iterator = list.iterator();
        while (iterator.hasNext()) {
            QuestionAnswer questionAnswer = iterator.next();
            if (questionAnswer.getQuestion() == question) {
                points += questionAnswer.getPoints();
            }
        }
        return points;
    }
}
