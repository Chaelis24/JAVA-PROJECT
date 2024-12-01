package quizProgram;

public class Main {
    public static void main(String[] args) {
        Question[] questions = {
            new Question("What kind of java loop is used to run a block of code for a certain number of times?", "For Loop"),
            new Question("What is the first computer?", "Abacus"),
            new Question("What type of data type uses a single character?", "Character"),
            new Question("What do you call the + (plus) operator between strings that adds them together to make a new string?", "Concatenation"),
            new Question("What do you call executes after each iteration of the loop?", "Increment and Decrement")
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}