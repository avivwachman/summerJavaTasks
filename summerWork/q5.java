package summerWork;
import java.util.Scanner;

public class q5 {
  /* ---------------- q5 b ---------------------- */
  static Scanner in = new Scanner(System.in);

  //short version of main bellow

  public static void main(String[] args) {
    int [] counterArr = new int [84];
    for (int i = 0; i < 672; i++) {
      int[] arr = new int[83];
      for (int j = 0; j < arr.length; j++) {
        p("enter to array "+i+" the at place of "+j +" out of "+ (arr.length-1));
        arr[j] = in.nextInt();
      }
      int firstNegative = negativePerformance(arr);
      counterArr[firstNegative]++;
    }
    for (int i = 1; i < counterArr.length; i++) {
      p("length n ("+i+") has "+counterArr[i]+" arrays at said length ");
    }
    p("number of arrays without negative (n = 0) are "+ counterArr[0]);
  }


  /* ---------------- q5 b short version!!! ---------------------- */

/*
  public static void main(String[] args) {
    int [] counterArr = new int [6];
    for (int i = 0; i < 3; i++) {
      int[] arr = new int[5];
      for (int j = 0; j < arr.length; j++) {
        p("enter to array "+i+" the at place of "+j +" out of "+ (arr.length-1));
        arr[j] = in.nextInt();
      }
      int firstNegative = negativePerformance(arr);
      counterArr[firstNegative]++;
    }
    for (int i = 1; i < counterArr.length; i++) {
      p("length n ("+i+") has "+counterArr[i]+" arrays at said length ");
    }
    p("number of arrays without negative (n = 0) are "+ counterArr[0]);
  }
*/

  /* ---------------- q5 a ---------------------- */
  public static int negativePerformance(int[] arr) {

    // variables
    boolean flag = false;
    boolean finish = false;
    int i = 0;
    int count = 0;

    while (!finish && i < arr.length) {
      if (flag) {
        if (arr[i] > 0) {
          count--;
          finish = true;
        }
        count++;
      } else {
        if (arr[i] < 0) {
          flag = true;
          count++;
        }
      }
      i++;
    }
    return count;
  }

  public static <T> void p(T s) { // make printing shorter
    System.out.println(s);
  }
}