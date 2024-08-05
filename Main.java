import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        for(int i=0;i<1;i++) {
            // m.hillCalimingTest();
            // m.beamSearchTest();
            // m.BFSTest();
            m.DFSTest();
        }
        
    }

    public void hillCalimingTest(){
        final int N = 1;
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
                // System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.hillCaliming(false, true, false,  3)) {
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
        double success = (double) completed / round;
        try {
            FileWriter writer = new FileWriter("stat.txt",true);
            writer.write((endTime - startTime) + " ");
            writer.write(success + "");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void beamSearchTest(){
        final int N = 250;
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
                // System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.beamSearch(false, false, 3)) {
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

        double success = (double) completed / round;
        try {
            FileWriter writer = new FileWriter("stat.txt",true);
            writer.write((endTime - startTime) + " ");
            writer.write(success + "");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void BFSTest(){
        final int N = 250;
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
                // System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.BFS(false, false, 15)) {
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
        double success = (double) completed / round;
        try {
            FileWriter writer = new FileWriter("stat.txt",true);
            writer.write((endTime - startTime) + " ");
            writer.write(success + "");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void DFSTest(){
        final int N = 250;
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
                // System.out.println("Progress: " + (round / tenPercent) * 10 + "%");
                percentCouter = 0;
            }
            if (p.DFS(false, false, 15)) {
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
        double success = (double) completed / round;
        try {
            FileWriter writer = new FileWriter("stat.txt",true);
            writer.write((endTime - startTime) + " ");
            writer.write(success + "");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    
}
