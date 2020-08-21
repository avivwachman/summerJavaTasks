package summerWork;
//Algorithm to return which number was rolled the most by dice,
// assuming only one number is the highest,
// if not the last number to have highest count will be returned

public class q1 {
  public static void main(String[] args) {
    int[] arr = {0,1,-2,8,3,7,8};
    System.out.println(mostCommon(arr));
  }

  public static int mostCommon (int[] arr){
      int max = 1;
    for (int i = 2; i < arr.length; i++) {
      if (arr[max]<=arr[i])
          max=i;
    }
    return  max;
  }

}
