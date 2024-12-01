package quizProgram;

import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private int correctAnswersCount;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.correctAnswersCount = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the IT Quiz Master!\n");

        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.checkAnswer(userAnswer)) {
                System.out.println("Your Answer is Correct!\n");
                correctAnswersCount++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz Completed!");
        System.out.println("Total Correct Answers: " + correctAnswersCount + " out of " + questions.length);
    }
}