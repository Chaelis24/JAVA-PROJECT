import java.util.concurrent.TimeUnit;

public class Kokoronashi {
    public static void main(String[] args) throws InterruptedException {
        
        double charDelay = 0.09;
        int lineDelay = 400;
        
        double charDelay2 = 0.11;
        int lineDelay2 = 500;
        
        double charDelay3 = 0.12;
        int lineDelay3 = 600;
        
        System.out.println("Kokoronashi\n");
        
        String[] lines = {
            "Kimi ni dore",
            "Dake aisarete mo",
            "Boku no",
            "Shinzou",
            "Wa hitot",
            "su dake"
        };
        
        String[] lines2 = {
            "Yamete yo",
            "Yamete yo,",
            "Yasashiku shinai de yo",
            "Doushite mo",
            "Boku ni wa",
            "Rikai ga dekinai yo",
            "Itai yo",
            "Itai yo,",
            "Kotoba de oshiete yo",
            "Konna no",
            "Shiranai yo",
            "Hitori ni",
            "Shinai de"
        };
        
        String[] lines3 = {
            "Hidoi yo",
            "Hidoi yo,"
        };
        String[] lines3a = {
            "mou, isso boku",
            "No karada wo"
        };
        String[] lines3b = {
            "Kowashite",
            "Hikisaite",
        };
        String[] lines3c = {
            "Suki na you, ni shite yo"
        };
        
        String[] lines4 = {
            "Sakende",
            "mogaite",
            "mabuta wo harashite mo",
            "Mada kimi wa",
            "boku no koto",
            "dakishimete hanasanai",
            "mou ii yo"
        };
        
        String[] lines5 = {
            "Nee, moshimo",
            "boku ni",
            "kokoro ga aru nara",
            "Dou yatte",
            "sore wo mitsukereba ii no?",
            "Sukoshi",
            "hohoende kimi ga iu",
            "'Sore wa ne,",
            "koko ni aru yo'"
        };
        //LINES 1
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay3 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay3);
        }
        System.out.println();
        //LINES 2
        for (String line : lines2) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay2 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay2);
        }
        System.out.println();
        //LINES 3
        for (double i = 3.10; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        for (String line : lines3) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay2 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay2);
        }
        //3a
        for (String line : lines3a) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        //3b
        for (String line : lines3b) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay2 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay2);
        }
        //3c
        for (String line : lines3c) {
            for (char c : line.toCharArray()) {
                double charDelayss = 0.08;
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelayss * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay);
        }
        System.out.println();
        //LINES 4
        for (String line : lines4) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay2 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay2);
        }
        System.out.println();
        //LINES 5
        for (double i = 21.50; i > 0; i--) {
            System.out.print("\r");
            Thread.sleep(1000);
        }
        for (String line : lines5) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep((long)(charDelay2 * 1000));
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(lineDelay2);
        }
    }
    
}