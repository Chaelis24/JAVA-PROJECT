import java.util.concurrent.TimeUnit;

public class TheOne {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The 1 by Taylor Swift\n");
        String[] lines = {
            /**"I, I, I persist and resist the temptation to ask you",
            "If one thing had been different",
            "Would everything be different today?",*/
            "We were something, don't you think so?",
            "Rosé flowing with your chosen family",
            "And it would've been sweet",
            "If it could've been me",
            "In my defense, I have none",
            "For digging up the grave another time",
            "But it would've been fun",
            "If you would've been the one"
        };

        // Define delays between characters
        double charDelay = 0.1;  // 100 ms between each character
        int lineDelay = 500;     // 500 ms between each line

        // Iterate over each line of the lyrics
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                // Flush the output to show the character immediately
                System.out.flush();
                // Delay for each character
                TimeUnit.MILLISECONDS.sleep((long)(charDelay * 1000));
            }
            // Move to the next line
            System.out.println();
            // Delay before printing the next line
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
    }
}
