public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        test.BFSTest();
    }

    public void hillCalimingTest() {
        final int N = 1;
        Puzzle8Slover p = new Puzzle8Slover();
        int round = 0;
        int percentCouter = 0;
        int tenPercent = N / 10;
        int completed = 0;
        System.out.println("Start simulation Puzzle8 " + N + " rounds");
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

    public void BFSTest() {
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
            if (p.BFS(false, false)) {
                completed++;
            }
        }

        // สิ้นสุดการจับเวลา
        long endTime = System.currentTimeMillis();
        long elapsedTimeMillis = endTime - startTime; // เวลาเป็นมิลลิวินาที

        // แปลงเวลาเป็นวินาทีและมิลลิวินาที
        long elapsedSeconds = elapsedTimeMillis / 1000;
        long remainingMillis = elapsedTimeMillis % 1000;

        System.out.println("Completed: " + completed);
        System.out.println("Time taken: " + elapsedSeconds);

        System.out.println("Number of rounds: " + round);
        System.out.println("Number of completed: " + completed);
        System.out.println("Success rate: " + (double) completed / round);
    }
}
