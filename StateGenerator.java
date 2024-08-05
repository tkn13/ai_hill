import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StateGenerator {

    public static void main(String[] args) {
        Puzzle8 goal = new Puzzle8(new int[][]{{1,2,3},
                                                {8, 0, 4},
                                                {7, 6, 5}});
        StateGenerator generator = new StateGenerator();
        generator.generateState(1000, goal);
        //Puzzle8 p = generator.readPuzzle8FromFile("input.txt", 0);
        //System.out.println(p);
    }
   
    
    public void generateState(int size, Puzzle8 goal) {

        String fileName = "input.txt";
    
        for(int i = 0; i < size; i++) {
            Puzzle8 puzzle = goal.generateInitState(goal, 50);
            int[][] state = puzzle.board;

            //wrtie to file
            try {
                FileWriter writer = new FileWriter(fileName, true);
                
                for(int j = 0; j < state.length; j++) {
                    for(int k = 0; k < state[j].length; k++) {
                        writer.write(state[j][k] + " ");
                    }
                }

                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }

    public Puzzle8 readPuzzle8FromFile(String fileName, int lineNum) {
        Puzzle8 puzzle = new Puzzle8();
        int[][] board = new int[3][3];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(count == lineNum) {
                    String[] values = line.split(" ");
                    int index = 0;
                    for(int i = 0; i < board.length; i++) {
                        for(int j = 0; j < board[i].length; j++) {
                            board[i][j] = Integer.parseInt(values[index]);
                            index++;
                        }
                    }
                    puzzle.board = board;
                    break;
                }
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return puzzle;
    }

}
