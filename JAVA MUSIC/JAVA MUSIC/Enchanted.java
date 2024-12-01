import java.util.concurrent.TimeUnit;

public class Enchanted {
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
        String[] lines2 = {
            "Please, don't be in love with someone else",
        };
        String[] lines3 = {
            "Please, don't have somebody waiting on you"
        };
        
        String[] chorus1 =  {"This night is sparkling,"};
        String[] chorusa1 = {"Don't you let it go"};
        String[] chorusb1 = {"I'm wonderstruck,"};
        String[] chorusc1 = {"Blushing all the way home"};
        String[] chorusd1 = {"I'll spend forever"};
        String[] choruse1 = {"Wondering if you knew"};
        
        String[] chorus2 =  {"This night is flawless,"};
        String[] chorusa2 = {"Don't you let it go"};
        String[] chorusb2 = {"I'm wonderstruck,"};
        String[] chorusc2 = {"Dancing 'round all alone"};
        String[] chorusd2 = {"I'll spend forever"};
        String[] choruse2 = {"Wondering if you knew"};
        String[] chorusf2 = {"I was enchanted to meet you"};
        
        double charDelay = 0.09;
        int lineDelay = 400;
        double charDelays = 0.11;
        int lineDelays = 300;
        double charDelayss = 0.12;
        int lineDelayss = 500;
        
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        System.out.println();
        for (int i = 3; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        for (String line : lines2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
        
        for (double i = 0.09; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        for (String line : lines3) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
        
        for (double i = 0.09; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        for (String line : lines2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
        
        for (double i = 0.09; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        for (String line : lines3) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
        
        System.out.println();
        for (double i = 0.11; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        //Chorus
        for (String line : chorus1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : chorusa1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        for (String line : chorusb1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : chorusc1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        for (String line : chorusd1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : choruse1) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        
        System.out.println();
        for (int i = 6; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        //Chorus 2
        for (String line : chorus2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : chorusa2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        for (String line : chorusb2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : chorusc2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        for (String line : chorusd2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelayss);
        }
        for (String line : choruse2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        for (String line : chorusf2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        
        for (int i = 1; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        
        for (String line : lines2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
        for (double i = 0.09; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        for (String line : lines3) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelays * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelays);
        }
    }
}