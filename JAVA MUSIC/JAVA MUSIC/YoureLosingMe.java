import java.util.concurrent.TimeUnit;

public class YoureLosingMe {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("You're Losing Me\n");
        String[] lines = {
            "How long could we be a sad song",
            "'Til we were too far gone to bring",
            "Back to life?",
            "I gave you all my best me's,",
            "My endless empathy",
            "And all I did was bleed as",
            "I tried to be the bravest soldier",
            "Fighting in only your army",
            "Frontlines, don't you ignore me",
            "I'm the best thing at this party",
            "(You're losing me)",
            "And I wouldn't marry me either",
            "A pathological people pleaser",
            "Who only wanted you to see her",
            "And I'm fadin', thinkin'",
            "Do something, babe, say something",
            "(Say something)",
            "Lose something, babe, risk something",
            "(You're losing me)",
            "Choose something, babe, I got nothing",
            "To believe",
            "Unless you're choosin' me"
        };

        // Adjust delays: slightly slower for emotional emphasis in the bridge
        double charDelay = 0.08;  // 120 ms between each character for a slower reveal
        int lineDelay = 500;      // 800 ms between each line for a more dramatic pause

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
