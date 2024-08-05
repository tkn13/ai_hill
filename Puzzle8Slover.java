import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Puzzle8Slover {
    Puzzle8 goal = new Puzzle8(new int[][] { { 1, 2, 3 },
            { 8, 0, 4 },
            { 7, 6, 5 } });
    // Puzzle8 start = new Puzzle8();

    // Puzzle8 start = new Puzzle8(new int[][] { { 1, 2, 3 },
    //         { 4, 6, 5 },
    //         { 7, 8, 0 } });
    ArrayList<String> AllData = new ArrayList<>();

    public Puzzle8Slover() {
        // readData();
    }

    public boolean hillCaliming(boolean devMode, boolean showSuccessStartState, boolean annealing) {
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 start = new Puzzle8();
        Puzzle8 current = start;
        visited.add(current);

        if (devMode) {
            System.out.println("Start state");
            System.out.println(current);
            System.out.println("Goal state");
            System.out.println(goal);
        }

        if (current.equals(goal)) {
            if (devMode)
                System.out.println("The start state is the goal state");
            return false;
        }

        if (devMode)
            System.out.println("--------------------------------");
        while (true) {

            if (devMode)
                System.out.println(current);
            if (devMode)
                System.out.println("Heuristic score: " + current.getHeuristicScore(goal) + "\n");

            if (current.isCanMoveUp()) {
                Puzzle8 p = new Puzzle8(current.moveUp());
                if (!visited.contains(p)) {
                    current.addState(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveDown()) {
                Puzzle8 p = new Puzzle8(current.moveDown());
                if (!visited.contains(p)) {
                    current.addState(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveLeft()) {
                Puzzle8 p = new Puzzle8(current.moveLeft());
                if (!visited.contains(p)) {
                    current.addState(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveRight()) {
                Puzzle8 p = new Puzzle8(current.moveRight());
                if (!visited.contains(p)) {
                    current.addState(p);
                    visited.add(p);
                }
            }

            if (devMode)
                System.out.println("All possible state");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                String line = "";
                for (Puzzle8 p : current.possibleState) {
                    line += p.getLine(i) + "\t\t";
                }
                sb.append(line + "\n");
            }
            for (Puzzle8 p : current.possibleState) {
                sb.append(p.getHeuristicScore(goal) + "\t\t");
            }
            if (devMode)
                System.out.println(sb.toString());
            if (devMode)
                System.out.println("-------------------------------------");

            Puzzle8 next = null;
            int bestScore = Integer.MAX_VALUE;
            for (Puzzle8 p : current.possibleState) {
                int currentScore = p.getHeuristicScore(goal);
                if (annealing) {
                    if (currentScore <= bestScore) {
                        if (currentScore == bestScore && next != null)
                            continue;
                        bestScore = currentScore;
                        next = p;
                    }
                } else {
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        next = p;
                    }
                }
            }

            if (bestScore == Integer.MAX_VALUE) {
                if (devMode)
                    System.out.println("All possible state have been visited");
                return false;
            }

            if (bestScore > current.getHeuristicScore(goal) && !annealing) {
                if (devMode)
                    System.out.println("Local maximum");
                return false;
            }
            if (next.equals(goal)) {
                if (devMode)
                    System.out.println("Goal state found");
                if (showSuccessStartState) {
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }
            current = next;
            // if(devMode) System.out.println("--------------------------------");
        }
    }

    public boolean BFS(boolean devMode, boolean showSuccessStartState) {
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 current;
        Queue<Puzzle8> allState = new LinkedList<>();
        Puzzle8 start = new Puzzle8();
        allState.add(start);

        while (!allState.isEmpty()) {
            current = allState.poll();
            if (current.equals(goal)) {
                if (devMode)
                    System.out.println("Goal state found");
                if (showSuccessStartState) {
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }

            if (current.isCanMoveUp()) {
                Puzzle8 p = new Puzzle8(current.moveUp());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveDown()) {
                Puzzle8 p = new Puzzle8(current.moveDown());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveLeft()) {
                Puzzle8 p = new Puzzle8(current.moveLeft());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveRight()) {
                Puzzle8 p = new Puzzle8(current.moveRight());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }

            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < 3; i++) {
            // String line = "";
            // for (Puzzle8 p : current.possibleState) {
            // line += p.getLine(i) + "\t\t";
            // }
            // sb.append(line + "\n");
            // }
        }
        return false;
    }

    public boolean BFS(boolean devMode, boolean showSuccessStartState,int depthLimit) {
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 current;
        Queue<Puzzle8> allState = new LinkedList<>();
        Puzzle8 start = new Puzzle8();
        allState.add(start);

        while (!allState.isEmpty()) {
            current = allState.poll();
            if (current.equals(goal)) {
                if (devMode)
                    System.out.println("Goal state found");
                if (showSuccessStartState) {
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }

            if(current.depth >= depthLimit) continue;

            if (current.isCanMoveUp()) {
                Puzzle8 p = new Puzzle8(current.moveUp());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveDown()) {
                Puzzle8 p = new Puzzle8(current.moveDown());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveLeft()) {
                Puzzle8 p = new Puzzle8(current.moveLeft());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveRight()) {
                Puzzle8 p = new Puzzle8(current.moveRight());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }

            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < 3; i++) {
            // String line = "";
            // for (Puzzle8 p : current.possibleState) {
            // line += p.getLine(i) + "\t\t";
            // }
            // sb.append(line + "\n");
            // }
        }
        return false;
    }

    public boolean DFS(boolean devMode, boolean showSuccessStartState) {
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 start = new Puzzle8();
        Puzzle8 current = start;
        Stack<Puzzle8> allState = new Stack<>();
        int round = 0;
        allState.add(start);

        while (!allState.isEmpty()) {
            current = allState.pop();
            if (current.equals(goal)) {
                if (devMode)
                    System.out.println("Goal state found");
                if (showSuccessStartState) {
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }

            if (current.isCanMoveUp()) {
                Puzzle8 p = new Puzzle8(current.moveUp());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveDown()) {
                Puzzle8 p = new Puzzle8(current.moveDown());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveLeft()) {
                Puzzle8 p = new Puzzle8(current.moveLeft());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveRight()) {
                Puzzle8 p = new Puzzle8(current.moveRight());
                if (!visited.contains(p)) {
                    p.depth = current.depth + 1;
                    allState.add(p);
                    visited.add(p);
                }
            }

            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < 3; i++) {
            // String line = "";
            // for (Puzzle8 p : current.possibleState) {
            // line += p.getLine(i) + "\t\t";
            // }
            // sb.append(line + "\n");
            // }
        }
        System.out.println(round);
        return false;
    }

    // private void writeStart(Puzzle8 start) {
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
    //         for (int i = 0; i < start.board.length; i++) {
    //             for (int j = 0; j < start.board[i].length; j++) {
    //                 writer.write(start.board[i][j] + " ");
    //             }
    //         }
    //         writer.write("\n");
    //     } catch (Exception e) {

    //     }
    // }

    // private int[][] createBoard(int index) {
    //     int[][] newBoard = new int[3][3];
    //     String d = AllData.get(index);
    //     String[] SplitData = d.split(" ");
    //     int k = 0;
    //     for(int i=0;i<newBoard.length;i++) {
    //         for(int j=0;j<newBoard[i].length;j++) {
    //             newBoard[i][j] = Integer.parseInt(SplitData[k]);
    //             k++;
    //         }
    //     }
    //     return newBoard;
    // }

    // private void readData() {
    //     try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    //         String line;

    //         // Read the file line by line
    //         while ((line = reader.readLine()) != null) {
    //             AllData.add(line);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace(); // Print stack trace for debugging
    //     }
    //     System.out.println(AllData.get(0));
    // }
}