public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.hillCalimingTest();
    }

    public void hillCalimingTest(){
        final int N = 10000;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        int beamSearchCompleted = 0;
        System.out.println("Start simulation Puzzle8 "+ N + " rounds");
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.hillCaliming(false, false, false,  3)) {
                completed++;
            }

            if(p.beamSearch(false, false, 3)){
                beamSearchCompleted++;
            }
        }
        System.out.println("\nSimulation completed");
        System.out.println("Hill Climbing");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);

        System.out.println("====================================");

        System.out.println("Beam Search");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + beamSearchCompleted);
        System.out.println("Success rate: " + (double) beamSearchCompleted / round);
    }
}
