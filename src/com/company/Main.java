package com.company;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Questions question = new Questions();
        QuestionsRoundOne roundOneQuestions = new QuestionsRoundOne();
        QuestionsRoundTwo roundTwoQuestions = new QuestionsRoundTwo();
        QuestionsRoundThree roundThreeQuestions = new QuestionsRoundThree();

        HashMap<String, String> r1Map = question.getQuestionsAndAnswersForRoundOne();
        HashMap<String, String> r2Map = question.getQuestionsAndAnswersForRoundTwo();
        HashMap<String, String> r3Map = question.getQuestionsAndAnswersForRoundThree();


    }

    public static void printRoundQuestions(HashMap<String, String> map){
        int counter = 1;
        for (Map.Entry<String, String> i : map.entrySet()) {
            System.out.println("Question "+counter+": "+i.getKey() + "\nAnswer: " + i.getValue());
            counter++;
        }
    }
}
