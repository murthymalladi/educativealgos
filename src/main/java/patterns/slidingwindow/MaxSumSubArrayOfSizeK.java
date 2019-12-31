package patterns.slidingwindow;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0,maxSum = 0;
        int n = arr.length;
        int wordStart = 0;
        for (int wordEnd = 0; wordEnd < arr.length; wordEnd++) {
            sum += arr[wordEnd];
            if (wordEnd >= k-1) {
                if (maxSum < sum) {
                    maxSum = sum;
                }
                sum = sum - arr[wordStart];
                wordStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }

}
