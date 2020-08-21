package summerWork;

import java.util.Scanner;

public class q3 {
    static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println( theWinner() );
  }

  public static int theWinner(){
    int[] arr = new int[41];
    for (int i = 0; i <25; i++) {
      System.out.println("Choose 3 favourite");
      int favOne= in.nextInt();
      System.out.println("second");
      int favTwo= in.nextInt();
      System.out.println("third");
      int favThree= in.nextInt();
      System.out.println("thanks!");
      arr[favOne]+=7;
      arr[favTwo]+=5;
      arr[favThree]+=1;
    }

    int max = 0;
    int maxI=-1;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i]>max)
            max=arr[i];
            maxI=i;
    }
    return maxI;
  }

  /* ---------------- Same with smaller parameters! ----------------------*/
   /* public static int theWinnerShort(){
        int[] arr = new int[6];
        for (int i = 0; i <3; i++) {
            System.out.println("Choose 3 favourite");
            int favOne= in.nextInt();
            System.out.println("second");
            int favTwo= in.nextInt();
            System.out.println("third");
            int favThree= in.nextInt();
            System.out.println("thanks!");
            arr[favOne]+=7;
            arr[favTwo]+=5;
            arr[favThree]+=1;
        }

        int max = 0;
        int maxI=-1;
        for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxI = i;
        }
    }

        return maxI;
    }*/

}
