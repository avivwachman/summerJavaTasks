package summerWork;

import java.util.Scanner;

public class q4 {
  static Scanner in = new Scanner(System.in);

  /* ---------------- q4 Gimel ---------------------- */
  public static void main(String[] args) {

    //    int[] arr = {544, 41, 1, 1462, -243, 32};
    //    System.out.println(isArrSpecial(arr));

    System.out.println("Arrays until special: \n 1.Enter length");
    int arr[] = new int[in.nextInt()];
    System.out.println("Enter array elements");
    for (int i = 0; i < arr.length; i++) {
      System.out.println("element " + i + " out of " + arr.length);
      arr[i] = in.nextInt();
    }
    boolean flag = true;
    while (flag) {
      if (isArrSpecial(arr)) {
        flag = false;
        System.out.println("\n this is special");
        q2.print(arr);
      } else {
        System.out.println("Next Array \n 1.Enter length");
        arr = new int[in.nextInt()];
        System.out.println("Enter array elements");
        for (int i = 0; i < arr.length; i++) {
          System.out.println("element " + (i+1) + " out of " + (arr.length-1));
          arr[i] = in.nextInt();
        }
      }
    }
  }

  /* ---------------- q4 Alef ---------------------- */
  public static int leftDigit(int num) {
    int holder = 0;
    num = Math.abs(num);
    while (num > 0) {
      holder = num % 10;
      num = num / 10;
    }
    return holder;
  }

  /* ---------------- q4 Bet ---------------------- */
  public static int digit(int num) {
    num = Math.abs(num);
    return num % 10;
  }

  public static boolean isArrSpecial(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (leftDigit(arr[i]) != digit(arr[i - 1])) return false;
    }
    return true;
  }

  /* ---------------- q4 Gimel ---------------------- */

  /* Didn't really understand instructions... hope I did right */
  // instead of Arrays.toString()


  // (Main is the  answer)
}
