import java.util.concurrent.TimeUnit;

public class MusicalLyrics {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("To The Bone\n");
        
        // Placeholder lyrics
        String[] lyrics = {
            "At sa paglisan ng araw, akala'y 'di ka mahal",
            "At ang nadarama'y hindi magtatagal",
            "Malay ko bang hindi magpapagal",
            "Iibigin kita kahit ga'no pa katagal"
        };
        
        // Countdown before the lyrics begin
        /**for (int i = 3; i > 0; i--) {
            System.out.print("Starting in " + i + "\r");
            Thread.sleep(1000); // 1 second delay
        }*/
        
        System.out.println("\n");  // Move to the next line after the countdown
        
        // Delay between words in milliseconds
        int wordDelay = 600;  // 500 milliseconds = 0.5 seconds
        
        // Print each word of the lyrics with a delay
        for (String line : lyrics) {
            String[] words = line.split(" ");  // Split line into words
            for (String word : words) {
                System.out.print(word + " ");
                TimeUnit.MILLISECONDS.sleep(wordDelay);  // Delay between words
            }
            System.out.println();  // Move to the next line after each sentence
        }
    }
}
