import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Puzzle8Slover {
    Puzzle8 goal = new Puzzle8(new int[][] { { 1, 2, 3 },
            { 8, 0, 4 },
            { 7, 6, 5 } });
    // Puzzle8 start = new Puzzle8();

    Puzzle8 start = new Puzzle8(new int[][] { { 2, 4, 1 },
            { 8, 5, 6 },
            { 3, 0, 7 } });

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
        Puzzle8 start = new Puzzle8();
        Puzzle8 current = start;
        ArrayList<Puzzle8> allState = new ArrayList<>();

        while (true) {
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
                    p.depth = ++current.depth;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveDown()) {
                Puzzle8 p = new Puzzle8(current.moveDown());
                if (!visited.contains(p)) {
                    p.depth = ++current.depth;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveLeft()) {
                Puzzle8 p = new Puzzle8(current.moveLeft());
                if (!visited.contains(p)) {
                    p.depth = ++current.depth;
                    allState.add(p);
                    visited.add(p);
                }
            }
            if (current.isCanMoveRight()) {
                Puzzle8 p = new Puzzle8(current.moveRight());
                if (!visited.contains(p)) {
                    p.depth = ++current.depth;
                    allState.add(p);
                    visited.add(p);
                }
            }

            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < 3; i++) {
            //     String line = "";
            //     for (Puzzle8 p : current.possibleState) {
            //         line += p.getLine(i) + "\t\t";
            //     }
            //     sb.append(line + "\n");
            // }

            if(allState.isEmpty()) break;

            Puzzle8 next = allState.get(0);
            allState.remove(0);
            
            current = next;
        }
        return false;
    }
}