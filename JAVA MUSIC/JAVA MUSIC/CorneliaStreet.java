import java.util.concurrent.TimeUnit;

public class CorneliaStreet {
    public static void main(String[] args) throws InterruptedException {
        // Modified lyrics of the chorus from "Cornelia Street" by Taylor Swift
        String[] lines = {
            "I rent a place on Cornelia Street",   // Modified line
            "Memories of you flood my heart again",   // Modified line
            "I could never let this feeling stay",   // Modified line
            "If you leave, I'd still call your name",   // Modified line
            "Oh, I still remember that road",   // Modified line
            "I'd never walk away, not from Cornelia Lane"   // Modified line
        };

        // Adjust delays: slightly slower for emotional emphasis in the chorus
        double charDelay = 0.15;  // 150 ms between each character
        int lineDelay = 700;      // 700 ms between each line

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
