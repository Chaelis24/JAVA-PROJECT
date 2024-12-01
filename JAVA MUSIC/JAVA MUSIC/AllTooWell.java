import java.util.concurrent.TimeUnit;

public class AllTooWell {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("All Too Well (10 Minutes Version)(Taylor's Version)(From The Vault)\n");
        
        String[] lyrics = {
            "Well, maybe we got lost in translation",
            "Maybe I asked for too much",
            "But maybe this thing was a masterpiece",
            "till you tore it all up",
            "Runnin' scared, I was there I remember",
            "it all too well",
            "And you call me up again just to",
            "break me like a promise",
            "So casually cruel in the name of bein' honest",
            "I'm a crumpled-up piece of paper lyin' here",
            "'Cause I remember it all, all, all"
        };
        
        for (int i = 0; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }

        // Delay between words in milliseconds
        int wordDelay = 500;  // 500 milliseconds = 0.5 seconds
        
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
