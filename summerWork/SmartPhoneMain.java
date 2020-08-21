package summerWork;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SmartPhoneMain {
  static Scanner in = new Scanner(System.in);

  /*-----------------------------Q ONEb-----------------------------*/

  public static void main(String[] args) {

    // BET 1)
    SmartPhone[] phoneArr = new SmartPhone[2]; //change!
    for (int i = 0; i < phoneArr.length; i++) {
      System.out.println("Enter (String newOwner, double newPrice, int battery, Date bought");
      phoneArr[i] = new SmartPhone(in.next(), in.nextDouble(), in.nextInt(), nextDate());
      System.out.println(" ");
    }

    // BET 2)
    String[] addApp = new String[4];
    for (int i = 0; i < addApp.length; i++) {
      System.out.println("Enter new App name for app at place " + i);
      addApp[i] = in.next();
    }

    System.out.println(Arrays.toString(addApp));

    for (int i = 0; i < phoneArr.length; i++) {
      phoneArr[i].addApplication(addApp[0]);
    }

    for (int i = 0; i < phoneArr.length; i += 2) { // even starting from i=0 regarding array place
      phoneArr[i].addApplication(addApp[1]);
    }

    for (int i = 0; i < phoneArr.length; i += 3) { // only i that divides by 3 without Remnants
      phoneArr[i].addApplication(addApp[2]);
    }
    for (SmartPhone smartPhone : phoneArr) {
      System.out.println(smartPhone.toString());
    }

    int[] arr = new int[2]; //change to 10
    Arrays.fill(arr, -999);

    int num = (int) (Math.random() * 2); //change 1 to 30

    while (!isArrFull(arr)) {
      if (!isNumInside(arr, num)) {
        push(arr, num);
      }
      num = (int) (Math.random() * 2); //change 1 to 30
    }

    System.out.println(Arrays.toString(arr) + "Hello");

    System.out.println("hoelo");

    for (int j : arr) {
      phoneArr[j].addApplication(addApp[3]);
    }

    for (SmartPhone smartPhone : phoneArr) {
      System.out.println(smartPhone.toString());
    }
  }

  // in order to get date input from user for phone
  public static Date nextDate() {
    System.out.println("(Date), Enter: int Year, int month, int day in month");
    int Year = in.nextInt();
    int Month = in.nextInt() + 1; // because Jan is index 0...
    int Date = in.nextInt();
    return new Date(Year, Month, Date);
  }

  // check if array has place
  public static boolean isArrFull(int[] arr) {
    for (int j : arr) {
      if (j == -999) return false;
    }
    return true;
  }

  // check if array has int num
  public static boolean isNumInside(int[] arr, int num) {
    for (int j : arr) {
      if (j == num) return true;
    }
    return false;
  }

  public static int push(int[] arr, int num) {

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -999) {
        arr[i] = num;
        return i;
      }
    }
    return -999;
  }
  }
