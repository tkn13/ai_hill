public class Main {
    public static void main(String[] args) {
        
    }

    public void hillCalimingTest(){
        final int N = 1;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("Start simulation Puzzle8 "+ N + " rounds");
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.hillCaliming(true, false, true)) {
                completed++;
            }
        }
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }
}
