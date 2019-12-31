package arrays;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class RemoveEven {

    public static int[] removeEven(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 1)
                count++;
        }
        int[] res = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i]%2 == 1) {
                res[j] = arr[i];
                j++;
            }
        return res;
    }
    public static void main(String args[]) {

        int size = 10;
        int[] arr = new int[size]; //declaration and instantiation

        System.out.print("Before removing Even Numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; // assigning values
            System.out.print(arr[i] +  " ");
        }
        System.out.println();

        int[] newArr =  removeEven(arr); // calling removeEven

        System.out.print("After removing Even Numbers: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] +  " "); // prinitng array
        }
    }
}
