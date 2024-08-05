public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.hillCalimingTest();
        m.beamSearchTest();
        m.BFSTest();
        m.DFSTest();
    }

    public void hillCalimingTest(){
        final int N = 1000;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("Start simulation Puzzle8 "+ N + " rounds");
        long startTime = System.currentTimeMillis();
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.hillCaliming(false, false, false,  3, round)) {
                completed++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
        System.out.println("\nSimulation completed");
        System.out.println("Hill Climbing");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }

    public void beamSearchTest(){
        final int N = 1000;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("\nStart simulation Puzzle8 "+ N + " rounds");
        long startTime = System.currentTimeMillis();
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.beamSearch(false, false, 3, round)) {
                completed++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
        System.out.println("\nSimulation completed");
        System.out.println("Beam Search");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }

    public void BFSTest(){
        final int N = 1000;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("\nStart simulation Puzzle8 "+ N + " rounds");
        long startTime = System.currentTimeMillis();
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.BFS(false, false, 25, round)) {
                completed++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
        System.out.println("\nSimulation completed");
        System.out.println("BFS");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }

    public void DFSTest(){
        final int N = 1000;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("\nStart simulation Puzzle8 "+ N + " rounds");
        long startTime = System.currentTimeMillis();
        while (round < N) {
            round++;
            percentCouter++;
            if (percentCouter == tenPercent) {
                System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.DFS(false, false, round)) {
                completed++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
        System.out.println("\nSimulation completed");
        System.out.println("DFS");
        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }

    
}
