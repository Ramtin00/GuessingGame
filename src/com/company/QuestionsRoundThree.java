package com.company;
import java.util.HashMap;


public class QuestionsRoundThree {
    private HashMap<String,String> roundThreeQuestions = new HashMap<>();

    private final String QUESTION1 = "What river runs through Baghdad?";
    private final String QUESTION2 = "In what country can you visit Machu Picchu?";
    private final String QUESTION3 = "Which African nation has the most pyramids?";

    private final String ANSWER1 = "Tigris";
    private final String ANSWER2 = "Peru";
    private final String ANSWER3 = "Sudan";



    public QuestionsRoundThree() {
        this.roundThreeQuestions.put(QUESTION1, ANSWER1);
        this.roundThreeQuestions.put(QUESTION2, ANSWER2);
        this.roundThreeQuestions.put(QUESTION3, ANSWER3);
    }


    public HashMap<String, String> getRoundThreeQuestions() {
        return roundThreeQuestions;
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
