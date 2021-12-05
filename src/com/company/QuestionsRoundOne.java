package com.company;
import java.util.HashMap;


public class QuestionsRoundOne {
    private HashMap<String,String> roundOneQuestions = new HashMap<>();

    private final String QUESTION1 = "What goes up and down, but always remains in the same place?";
    private final String QUESTION2 = "What city do The Beatles come from?";
    private final String QUESTION3 = "When was Netflix founded: 1997, 2001, 2009, 2015?";

    private final String ANSWER1 = "Stairs";
    private final String ANSWER2 = "Liverpool";
    private final String ANSWER3 = "1997";


    public QuestionsRoundOne() {
        this.roundOneQuestions.put(QUESTION1, ANSWER1);
        this.roundOneQuestions.put(QUESTION2, ANSWER2);
        this.roundOneQuestions.put(QUESTION3, ANSWER3);
    }


    public HashMap<String, String> getRoundOneQuestions() {
        return roundOneQuestions;
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

    @Override
    public String toString() {
        return "QuestionsRoundOne{}";
    }
}
