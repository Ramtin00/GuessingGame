package com.company;
import java.util.HashMap;


public class QuestionsRoundTwo {
    private HashMap<String,String> roundTwoQuestions = new HashMap<>();

    private final String QUESTION1 = "I have 4 legs and a tail. I have whiskers. People like to keep me as a pet. What am I?";
    private final String QUESTION2 = "I am a bird. I can swim but I can’t fly. I am black and white. What am I?";
    private final String QUESTION3 = "I am a big cat. I have big sharp teeth. I have orange fur and black stripes. What am I?";

    private final String ANSWER1 = "cat";
    private final String ANSWER2 = "penguin";
    private final String ANSWER3 = "tiger";


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
