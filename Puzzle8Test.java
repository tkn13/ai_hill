public class Puzzle8Test {

    public static void main(String[] args){
        Puzzle8 p = new Puzzle8(new int[][]{{3, 2, 8}, {4, 1, 7}, {5, 0, 6}});
        System.out.println(p);

        if(p.isCanMoveUp()){
            System.out.println("Can move up");
            System.out.println(new Puzzle8(p.moveUp()));
        }

        if(p.isCanMoveDown()){
            System.out.println("Can move down");
            System.out.println(new Puzzle8(p.moveDown()));
        }

        if(p.isCanMoveLeft()){
            System.out.println("Can move left");
            System.out.println(new Puzzle8(p.moveLeft()));
        }

        if(p.isCanMoveRight()){
            System.out.println("Can move right");
            System.out.println(new Puzzle8(p.moveRight()));
        }
    }
}
