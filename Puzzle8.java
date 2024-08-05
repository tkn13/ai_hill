import java.util.ArrayList;
import java.util.Collections;

public class Puzzle8 {
    int[][] board;
    int boardSize;
    Puzzle8 pervious;
    Puzzle8 next;
    int depth = 0;
    int maxDepth = Integer.MAX_VALUE;
    ArrayList<Puzzle8> possibleState = new ArrayList<>();
    

    public Puzzle8(int[][] board) {
        this.board = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, this.board[i], 0, board[i].length);
        }

        boardSize = board.length;
    }

    public Puzzle8(int[][] board, Puzzle8 pervious) {
        this.board = board;
        this.pervious = pervious;
        boardSize = board.length;
    }

    public Puzzle8(){
        boardSize = 3;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < boardSize*boardSize; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        board = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = list.get(i * boardSize + j);
            }
        }
    }

    public Puzzle8(int boardSize){
        this.boardSize = boardSize;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < boardSize*boardSize; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        board = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = list.get(i * boardSize + j);
            }
        }
    }

    public Puzzle8 deepCopyPuzzle8(Puzzle8 src){
        int[][] newBoard = new int[src.boardSize][src.boardSize];
        for(int i = 0; i < src.board.length; i++){
            System.arraycopy(src.board[i], 0, newBoard[i], 0, src.board[i].length);
        }
        return new Puzzle8(newBoard);
    }

    public boolean isCanMoveUp(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && i > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCanMoveDown(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && i < board.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCanMoveLeft(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && j > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCanMoveRight(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && j < board[i].length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[][] moveUp(){
        int[][] newBoard = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        Point p = getIndex(0);
        newBoard[p.x][p.y] = newBoard[p.x - 1][p.y];
        newBoard[p.x - 1][p.y] = 0;
        return newBoard;
    }

    public int[][] moveDown(){
        int[][] newBoard = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        Point p = getIndex(0);
        newBoard[p.x][p.y] = newBoard[p.x + 1][p.y];
        newBoard[p.x + 1][p.y] = 0;
        return newBoard;
    }

    public int[][] moveLeft(){
        int[][] newBoard = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        Point p = getIndex(0);
        newBoard[p.x][p.y] = newBoard[p.x][p.y - 1];
        newBoard[p.x][p.y - 1] = 0;
        return newBoard;
    }

    public int[][] moveRight(){
        int[][] newBoard = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        Point p = getIndex(0);
        newBoard[p.x][p.y] = newBoard[p.x][p.y + 1];
        newBoard[p.x][p.y + 1] = 0;
        return newBoard;
    }

    public int getHeuristicScore(Puzzle8 goal) {
        int score = 0;

        for(int i = 1; i <= (boardSize * boardSize)-1; i++){
            Point p1 = getIndex(i);
            Point p2 = goal.getIndex(i);
            score += Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }

        return score;
    }

    public Puzzle8 generateInitState(Puzzle8 goal, int round){
        Puzzle8 initState = new Puzzle8(goal.board);
        
        for(int i = 0; i < round; i++){
            ArrayList<Puzzle8> possibleState = new ArrayList<>();
            if (initState.isCanMoveUp()) {
                possibleState.add(new Puzzle8(initState.moveUp(), initState));
            }
            if (initState.isCanMoveDown()) {
                possibleState.add(new Puzzle8(initState.moveDown(), initState));
            }
            if (initState.isCanMoveLeft()) {
                possibleState.add(new Puzzle8(initState.moveLeft(), initState));
            }
            if (initState.isCanMoveRight()) {
                possibleState.add(new Puzzle8(initState.moveRight(), initState));
            }

            Collections.shuffle(possibleState);
            initState = possibleState.get(0);
        }
        return initState;
    }

    public void addState(Puzzle8 state){
        //check if it is already in the list
        // for (Puzzle8 p : possibleState) {
        //     if (p.equals(state)) {
        //         return;
        //     }
        // }
        possibleState.add(state);
    }

    
    public Point getIndex(int v){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == v) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                hash = 31 * hash + board[i][j];
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Puzzle8)) {
            return false;
        }
        Puzzle8 other = (Puzzle8) obj;
        for(int i = 0; i < other.board.length; i++) {
            for(int j = 0; j < other.board[i].length; j++) {
                if (other.board[i][j] != this.board[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override 
    public String toString() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            result += "|";
            for (int j = 0; j < board[i].length; j++) {
                result += board[i][j] + "|";
            }
            result += "\n";
        }
        return result;
    }

    public String getLine(int line){
        String result = "|";
        for (int j = 0; j < board[line].length; j++) {
            result += board[line][j]+"|";
        }
        return result;
    }
}