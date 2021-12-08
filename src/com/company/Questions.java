package com.company;
import java.util.HashMap;

public class Questions {

    HashMap<String, HashMap<String, String>> allQuestions = new HashMap<>();
    Questions question = new Questions();
    QuestionsRoundOne roundOneQuestions = new QuestionsRoundOne();
    QuestionsRoundTwo roundTwoQuestions = new QuestionsRoundTwo();
    QuestionsRoundThree roundThreeQuestions = new QuestionsRoundThree();

    HashMap<String, String> r1Map = question.getQuestionsAndAnswersForRoundOne();
    HashMap<String, String> r2Map = question.getQuestionsAndAnswersForRoundTwo();
    HashMap<String, String> r3Map = question.getQuestionsAndAnswersForRoundThree();

    public Questions() {
        QuestionsRoundOne roundOne = new QuestionsRoundOne();
        allQuestions.put("Round 1", roundOne.getRoundOneQuestions());

        QuestionsRoundTwo roundTwo = new QuestionsRoundTwo();
        allQuestions.put("Round 2", roundTwo.getRoundTwoQuestions());

        QuestionsRoundThree roundThree = new QuestionsRoundThree();
        allQuestions.put("Round 3", roundThree.getRoundThreeQuestions());
    }


    public HashMap<String,String> getQuestionsAndAnswersForRoundOne(){
        HashMap<String, String> result = new HashMap<>(allQuestions.get("Round 1"));
        return result;
    }

    public HashMap<String,String> getQuestionsAndAnswersForRoundTwo(){
        return new HashMap<>(allQuestions.get("Round 2"));
    }

    public HashMap<String,String> getQuestionsAndAnswersForRoundThree(){
        return new HashMap<>(allQuestions.get("Round 3"));
    }
}
