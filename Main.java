import java.io.FileWriter;
import java.io.IOException;

public class Main {

    Puzzle8Slover p = new Puzzle8Slover("output/input50.txt");
    public static void main(String[] args) {
        Main m = new Main();
        m.hillCalimingTest();
        m.beamSearchTest();
        m.BFSTest();
        m.DFSTest();
    }

    public void hillCalimingTest(){
        final int N = 1000;
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
        final int N = 1000;
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
        final int N = 1000;
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
        final int N = 1000;
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


    public void complexTest(){
        Puzzle8Slover complex = new Puzzle8Slover("input.txt");
        System.out.println("Hill Climbing");
        for(int i = 10; i <= 200; i+=10){
            complex.fileName = "output/input" + i + ".txt";

            int round = 1000;
            int completed = 0;
            for(int j = 0; j < round; j++) {
                if(complex.hillCaliming(false, false, false, 3, j)) {
                    completed++;
                }
            }
            System.out.println("Completed: " + ((completed * 1.0) / (round * 1.0)) * 100 + " %");
        }

        System.out.println("Beam Search");
        for(int i = 10; i <= 200; i+=10){
            complex.fileName = "output/input" + i + ".txt";

            int round = 1000;
            int completed = 0;
            for(int j = 0; j < round; j++) {
                if(complex.beamSearch(false, false, 3, j)) {
                    completed++;
                }
            }
            System.out.println("Completed: " + ((completed * 1.0) / (round * 1.0)) * 100 + " %");
        }
    }

    
}
