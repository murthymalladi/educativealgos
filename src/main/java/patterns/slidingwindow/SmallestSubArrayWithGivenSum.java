package patterns.slidingwindow;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class SmallestSubArrayWithGivenSum {

    public static int findMinSubArray(int S, int[] arr) {
        int sum=0;
        int wordStart = 0;
        int min = Integer.MAX_VALUE;
        for (int wordEnd = 0; wordEnd < arr.length; wordEnd++) {
            sum += arr[wordEnd];
            while(sum >= S) {
               if (min > wordEnd - wordStart+1) {
                    min = wordEnd - wordStart +1;
                }
                sum = sum - arr[wordStart];
                wordStart++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }

}
