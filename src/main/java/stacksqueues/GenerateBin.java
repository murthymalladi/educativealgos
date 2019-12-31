package stacksqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dmalladi on 12/30/2019.
 */
public class GenerateBin {

    public static String[] findBin(int number) {
        String[] res = new String[number];
        Queue<String> queue = new LinkedList<String>();

        queue.add("1");
        for (int i = 0; i < number; i++) {
            String bin = queue.poll();
            String s1 = bin+"0";
            String s2 = bin+"1";
            queue.add(s1);
            queue.add(s2);
            res[i] = bin;
        }
        return res;
    }

    public static void main(String args[]) {
        int number = 8;
        String[] output = findBin(number);
        for(int i = 0; i < number; i++)
            System.out.print(output[i] + " ");
    }

}
