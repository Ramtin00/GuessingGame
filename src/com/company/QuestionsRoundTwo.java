package com.company;
import java.util.HashMap;


public class QuestionsRoundTwo {
    private HashMap<String,String> roundTwoQuestions = new HashMap<>();
    private final String QUESTION1 = "R2Q1";
    private final String QUESTION2 = "R2Q2";
    private final String QUESTION3 = "R2Q3";

    private final String ANSWER1 = "R2A1";
    private final String ANSWER2 = "R2A2";
    private final String ANSWER3 = "R2A3";



    public QuestionsRoundTwo() {
        this.roundTwoQuestions.put(QUESTION1, ANSWER1);
        this.roundTwoQuestions.put(QUESTION2, ANSWER2);
        this.roundTwoQuestions.put(QUESTION3, ANSWER3);
    }


    public HashMap<String, String> getRoundTwoQuestions() {
        return roundTwoQuestions;
    }

    public String getQUESTION1() {
        return QUESTION1;
    }

    public String getQUESTION2() {
        return QUESTION2;
    }

    public String getQUESTION3() {
        return QUESTION3;
    }

    public String getANSWER1() {
        return ANSWER1;
    }

    public String getANSWER2() {
        return ANSWER2;
    }

    public String getANSWER3() {
        return ANSWER3;
    }
}
