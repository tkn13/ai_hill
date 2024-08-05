import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProblemGen {
    public static int count = 0;
    public static void main(String[] args) {
        ProblemGen test = new ProblemGen();
        test.startGen(9);
        System.out.println(count);
    }

    public void startGen(int maxSize) {
        boolean[] boolArray = new boolean[maxSize];

        for (int i = 0; i < maxSize; i++) {
            boolArray[i] = false;
        }

        ArrayList<Integer> currentNum = new ArrayList<>();
        // recursiveGen(boolArray, 0, maxSize, currentNum);

        try (FileWriter writer = new FileWriter("8puzzlePloblem.txt")) {
            recursiveGen(boolArray, 0, maxSize, currentNum, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recursiveGen(boolean[] numBool, int depth, int maxDepth, ArrayList<Integer> currentNum, FileWriter writer) throws IOException{
        if(depth >= maxDepth) {
            count++;
            writer.write(currentNum.toString() + "\n");
            return;
        }
        for(int i=0;i<maxDepth;i++) {
            if(numBool[i]) continue;
            currentNum.add(i);
            numBool[i] = true;
            recursiveGen(numBool, depth+1, maxDepth, currentNum, writer);
            currentNum.remove(currentNum.size()-1);
            numBool[i] = false;
        }
    }
}
