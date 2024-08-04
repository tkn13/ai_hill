import java.util.ArrayList;
import java.util.HashSet;

public class Puzzle8Slover {
    Puzzle8 goal1 = new Puzzle8(new int[][]{{1, 2, 3},
                                            {4, 5, 6},
                                            {7, 8, 0}});

    Puzzle8 goal2 = new Puzzle8(new int[][]{{1,2,3},
                                            {8,0,4},
                                            {7,6,5}});
    
    Puzzle8 goal = goal2;

      public boolean hillCaliming(boolean devMode, boolean showSuccessStartState, boolean annealing, int boardSize) {
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 start = new Puzzle8(boardSize);
        Puzzle8 current = start;
        visited.add(current);
        int perviousScore = Integer.MAX_VALUE;

        if(devMode){
            System.out.println("Start state");
            System.out.println(current);
            System.out.println("Goal state");
            System.out.println(goal);
        }

        if(current.equals(goal)){
            if(devMode) System.out.println("The start state is the goal state");
            return false;
        }

        if(devMode) System.out.println("--------------------------------");
        while(true){

            if(devMode) System.out.println(current);
            if(devMode) System.out.println("Heuristic score: " + current.getHeuristicScore(goal) + "\n");

            if(current.isCanMoveUp()){
               Puzzle8 p = new Puzzle8(current.moveUp());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveDown()){
               Puzzle8 p = new Puzzle8(current.moveDown());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveLeft()){
               Puzzle8 p = new Puzzle8(current.moveLeft());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveRight()){
               Puzzle8 p = new Puzzle8(current.moveRight());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }

            if(devMode) System.out.println("All possible state");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < boardSize; i++){
                String line = "";
                for(Puzzle8 p : current.possibleState){
                    line += p.getLine(i) + "\t\t";
                }
                sb.append(line + "\n");
            }
            for(Puzzle8 p : current.possibleState){
                sb.append(p.getHeuristicScore(goal) + "\t\t");
            }
            if(devMode) System.out.println(sb.toString());
            if(devMode) System.out.println("-------------------------------------");
            

            Puzzle8 next = null;
            int bestScore = Integer.MAX_VALUE;
            for(Puzzle8 p : current.possibleState){
                int currentScore = p.getHeuristicScore(goal);
                if(annealing){
                    if(currentScore <= bestScore && currentScore <= perviousScore){
                        if(currentScore == bestScore && next != null) continue;
                        bestScore = currentScore;
                        next = p;
                    }
                } else {
                    if(currentScore < bestScore && currentScore < perviousScore){
                        bestScore = currentScore;
                        next = p;
                    }
                }
            }

            if(bestScore == Integer.MAX_VALUE){
                if(devMode) System.out.println("All possible state have been visited");
                return false;
            }

            if(bestScore > current.getHeuristicScore(goal) && !annealing){
                if(devMode) System.out.println("Local maximum");
                return false;
            }
            if(next.equals(goal)){
                if(devMode) System.out.println("Goal state found");
                if(showSuccessStartState){
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }
            current = next;
            perviousScore = bestScore;
            //if(devMode) System.out.println("--------------------------------");
        }
   }

    public boolean beamSearch(boolean devMode, boolean showSuccessStartState, int boardSize){
        HashSet<Puzzle8> visited = new HashSet<>();
        Puzzle8 start = new Puzzle8(boardSize);
        Puzzle8 current = start;
        visited.add(current);
        int beamWidth = 2;
        int round = 0;

        if(devMode){
            System.out.println("Start state");
            System.out.println(current);
            System.out.println("Goal state");
            System.out.println(goal);
        }

        if(current.equals(goal)){
            if(devMode) System.out.println("The start state is the goal state");
            return false;
        }

        if(devMode) System.out.println("--------------------------------");
        while(true){
            round++;
            if(devMode) System.out.println("Round: " + round);
            if(devMode) System.out.println(current);
            if(devMode) System.out.println("Heuristic score: " + current.getHeuristicScore(goal) + "\n");

            if(current.isCanMoveUp()){
               Puzzle8 p = new Puzzle8(current.moveUp());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveDown()){
               Puzzle8 p = new Puzzle8(current.moveDown());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveLeft()){
               Puzzle8 p = new Puzzle8(current.moveLeft());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }
            if(current.isCanMoveRight()){
               Puzzle8 p = new Puzzle8(current.moveRight());
               if(!visited.contains(p)){
                   current.addState(p);
                   visited.add(p);
               }
            }

            if(devMode) System.out.println("All possible state");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < boardSize; i++){
                String line = "";
                for(Puzzle8 p : current.possibleState){
                    line += p.getLine(i) + "\t\t";
                }
                sb.append(line + "\n");
            }
            for(Puzzle8 p : current.possibleState){
                sb.append(p.getHeuristicScore(goal) + "\t\t");
            }
            if(devMode) System.out.println(sb.toString());
            if(devMode) System.out.println("-------------------------------------");
            

            Puzzle8 next = deptSearch(current, 2, 2, visited);
            if(next == null){
                if(devMode) System.out.println("All possible state have been visited");
                return false;
            }
            if(next.equals(goal)){
                if(devMode) System.out.println("Goal state found");
                if(showSuccessStartState){
                    System.out.println("Start state");
                    System.out.println(start);
                }
                return true;
            }
            current = next;
            //if(devMode) System.out.println("--------------------------------");
        }
            
    }

    private Puzzle8 deptSearch(Puzzle8 current, int dept, int beamWidth, HashSet<Puzzle8> visited){
        ArrayList<Puzzle8> allPossible = new ArrayList<>(current.possibleState);
        //sort by heuristic score in ascending order
        allPossible.sort((p1, p2) -> p1.getHeuristicScore(goal) - p2.getHeuristicScore(goal));
        int count = 0;
        Puzzle8 bestOne = null;
        int bestScore= Integer.MAX_VALUE;
        while(count < beamWidth){
            if(count >= allPossible.size()){
                break;
            }
            Puzzle8 p = new Puzzle8(allPossible.get(count).board);
            if(p.equals(goal)){
                return p;
            }
            int round = 0;
            HashSet<Puzzle8> visited2 = new HashSet<>(visited);
            Puzzle8 temp = p;
            visited2.add(temp);
            visited2.add(current);
            // System.out.println("selected state");
            // System.out.println(temp); 
            while(round < dept){
                round++;
                if(temp.isCanMoveUp()){
                    Puzzle8 p1 = new Puzzle8(temp.moveUp());
                    if(!visited2.contains(p1)){
                        temp.addState(p1);
                        visited2.add(p1);
                    }
                }
                if(temp.isCanMoveDown()){
                    Puzzle8 p1 = new Puzzle8(temp.moveDown());
                    if(!visited2.contains(p1)){
                        temp.addState(p1);
                        visited2.add(p1);
                    }
                }
                if(temp.isCanMoveLeft()){
                    Puzzle8 p1 = new Puzzle8(temp.moveLeft());
                    if(!visited2.contains(p1)){
                        temp.addState(p1);
                        visited2.add(p1);
                    }
                }
                if(temp.isCanMoveRight()){
                    Puzzle8 p1 = new Puzzle8(temp.moveRight());
                    if(!visited2.contains(p1)){
                        temp.addState(p1);
                        visited2.add(p1);
                    }
                }
                Puzzle8 next = null;
                int bestScore2 = Integer.MAX_VALUE;
                for(Puzzle8 p1 : temp.possibleState){
                    int currentScore = p1.getHeuristicScore(goal);
                    if(currentScore < bestScore2){
                        bestScore2 = currentScore;
                        next = p1;
                    }
                }
                if(next == null){
                    count++;
                    break;
                }
                temp = next;
                // System.out.println("chosen state");
                // System.out.println(temp);
                // System.out.println("Heuristic score: " + temp.getHeuristicScore(goal) + "\n");
            }
            if(round == dept && temp.getHeuristicScore(goal) < bestScore){
                bestScore = temp.getHeuristicScore(goal);
                bestOne = p;
            }
            count++;
        }
    
        if(bestOne == null){
            return null;
        }
        // System.out.println("Best one");
        // System.out.println(bestOne);
        return new Puzzle8(bestOne.board);
    }
}
