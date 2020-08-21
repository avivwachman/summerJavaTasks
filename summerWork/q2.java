package summerWork;

import java.util.Scanner;

/*

        Notice!
                I didn't understand if the arr should be size of n or not
                In the example the array length is 7 but n is 6
                So I did both



 */



public class q2 {

    static Scanner in = new Scanner(System.in);

/*------------------------------Q2b--------------------  */

  public static void main(String[] args) {
    System.out.println("Enter n for factorial");
    int n = in.nextInt();
    System.out.println("Factorial without n included");
    print(factorial(n));
    System.out.println("Factorial with n included");
    print(factorialInclude(n));

  }
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i + 1 == arr.length) System.out.println("]");
            else System.out.print(", ");
        }
    }

  /*------------------------------Q2a--------------------  */

    public static int[] factorial (int n) { //not including 6
      int[] arr = new int[n];
      arr[0]=1;
      arr[1]=1;
      for (int i= 2; i <n; i++) {
      arr[i]=i*arr[i-1];
    }
      return arr;
    }

    public static int[] factorialInclude (int n) { //including 6
        int[] arr = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i= 2; i <=n; i++) {
            arr[i]=i*arr[i-1];
        }
        return arr;
    }

}
