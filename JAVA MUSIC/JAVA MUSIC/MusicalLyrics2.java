import java.util.concurrent.TimeUnit;

public class MusicalLyrics2 {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Enchanted (Taylor's Version)\n");
        
        String[] lines = {
            "This is me praying that",
            "This was the very first page",
            "Not where the story line ends",
            "My thoughts will echo your name,",
            "Until I see you again",
            "These are the words I held back,",
            "As I was leaving too soon",
            "I was enchanted to meet you"
        };
        String[] bridge1 = {
            "Please, don't be in love with someone else",
        };
        String[] bridge2 = {
            "Please, don't have somebody waiting on you"
        };
        
        String[] chorus1 =  {
            "This night is sparkling,", 
            "Don't you let it go",
            "I'm wonderstruck,",
            "Blushing all the way home",
            "I'll spend forever",
            "Wondering if you knew"
        };

        String[] chorus2 =  {
            "This night is flawless,", 
            "Don't you let it go",
            "I'm wonderstruck,",
            "Dancing 'round all alone",
            "I'll spend forever",
            "Wondering if you knew",
            "I was enchanted to meet you"
        };
        
        double charDelay = 0.09; // Character delay
        int lineDelay = 400;     // Line delay
        double bridgeCharDelay = 0.11; // Delay for the bridge
        int bridgeLineDelay = 500;     // Line delay for the bridge
        double chorusCharDelay = 0.12; // Chorus delay
        int chorusLineDelay = 600;     // Chorus line delay
        
        // Function to print lines with character-by-character delay
        printWithDelay(lines, charDelay, lineDelay);
        System.out.println();
        
        // Bridge (first part)
        printWithDelay(bridge1, bridgeCharDelay, bridgeLineDelay);
        printWithDelay(bridge2, bridgeCharDelay, bridgeLineDelay);
        
        // Chorus 1
        printWithDelay(chorus1, chorusCharDelay, chorusLineDelay);
        
        // Short pause before repeating bridge
        TimeUnit.SECONDS.sleep(2);
        
        // Repeating bridge (second part)
        printWithDelay(bridge1, bridgeCharDelay, bridgeLineDelay);
        printWithDelay(bridge2, bridgeCharDelay, bridgeLineDelay);
        
        // Chorus 2
        printWithDelay(chorus2, chorusCharDelay, chorusLineDelay);
        
        // Final bridge
        TimeUnit.SECONDS.sleep(2);
        printWithDelay(bridge1, bridgeCharDelay, bridgeLineDelay);
        printWithDelay(bridge2, bridgeCharDelay, bridgeLineDelay);
    }
    
    // Function to handle the character-by-character printing
    public static void printWithDelay(String[] lines, double charDelay, int lineDelay) throws InterruptedException {
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long) (charDelay * 1000)); // Delay between characters
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay); // Delay between lines
        }
    }
}
