package summerWork;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SmartPhoneMain {
  static Scanner in = new Scanner(System.in);


  //One can replace in.nextInt with Integer.valueOf(in.nextLine()) for int
  // and use in.nextLine instead of in.next for String for better practice
  // the way I chose works only with Strings that consist of one word (won't read after first space)


  /*           -----------------------------Bet-----------------------------*/

  public static void main(String[] args) {

    //             ---------------------- BET 1) ----------------------
    SmartPhone[] phoneArr = new SmartPhone[30];
    one(phoneArr);

    //             ---------------------- BET 2) ----------------------
    two(phoneArr);

    //             ---------------------- BET 3) ----------------------

    show(phoneArr);

    //             ---------------------- BET 4) ----------------------

    priceRise(phoneArr);

    //             ---------------------- BET 5) ----------------------

    charge(phoneArr);

    //             ---------------------- BET 6) ----------------------

    mostExp(phoneArr);

    //             ---------------------- BET 7) ----------------------

    System.out.println(mostCheap(phoneArr).toString());


    //             ---------------------- BET 8) ----------------------
    del(phoneArr);

    //             ---------------------- BET 9) ----------------------

    add(phoneArr);

    //             ---------------------- Show ----------------------

    show(phoneArr);
  }

  //            ------------------------Bet 1)------------------------

  public static void one(SmartPhone[] phoneArr) {
    for (int i = 0; i < phoneArr.length; i++) {
      System.out.println("Enter (String newOwner, double newPrice, int battery, Date bought");
      phoneArr[i] = new SmartPhone(in.next(), in.nextDouble(), in.nextInt(), nextDate());
      System.out.println(" ");
    }
  }

  //             ---------------------- BET 2) ----------------------
  public static void two(SmartPhone[] phoneArr) {
    String[] addApp = new String[4];

    for (int i = 0; i < addApp.length; i++) {
      System.out.println("Enter new App name for app at place " + i);
      addApp[i] = in.next();
    }

    for (SmartPhone smartPhone : phoneArr) {
      smartPhone.addApplication(addApp[0]);
    }

    for (int i = 0; i < phoneArr.length; i += 2) { // even starting from i=0 regarding array place
      phoneArr[i].addApplication(addApp[1]);
    }

    for (int i = 0; i < phoneArr.length; i += 3) { // only i that divides by 3 without Remnants
      phoneArr[i].addApplication(addApp[2]);
    }

    int[] arr = new int[10];
    Arrays.fill(arr, -999);

    int num = (int)(Math.random() * 30);

    while (!isArrFull(arr)) {
      if (!isNumInside(arr, num)) {
        push(arr, num);
      }
      num = (int)(Math.random() * 30);
    }

    for (int j : arr) {
      phoneArr[j].addApplication(addApp[3]);
    }
  }

  //             ---------------------- BET 3) ----------------------
  public static void show(SmartPhone[] phoneArr) {
    for (SmartPhone smartPhone : phoneArr) {
      System.out.println(smartPhone.toString());
    }
  }

  //             ---------------------- BET 4) ----------------------
  public static void priceRise(SmartPhone[] phoneArr) {
    for (SmartPhone smartPhone : phoneArr) {
      smartPhone.setPrice(smartPhone.getPrice() * 1.2);
    }
  }

  //             ---------------------- BET 5) ----------------------
  public static void charge(SmartPhone[] phoneArr) {
    for (SmartPhone smartPhone : phoneArr) {
      if (smartPhone.getBattery() < 30) {
        smartPhone.setBattery(100);
      }
    }
  }

  //             ---------------------- BET 6) ----------------------

  public static void mostExp(SmartPhone[] phoneArr) {
    double maxPrice = phoneArr[0].getPrice();
    String maxName = phoneArr[0].getOwner();
    for (int i = 1; i < phoneArr.length; i++) {
      if (maxPrice < phoneArr[i].getPrice()) {
        maxPrice = phoneArr[i].getPrice();
        maxName = phoneArr[i].getOwner();
      }
    }
    System.out.println("Most expensive phone's name is " + maxName);
  }

  //             ---------------------- BET 7) ----------------------

  public static SmartPhone mostCheap(SmartPhone[] phoneArr) {
    System.out.println("Enter Owner tz for cheapest phone owner has");
    String owner = in.next();

    SmartPhone[] ownerPhones = new SmartPhone[100];
    int place = 0;
    for (int i = 0; i < phoneArr.length; i++) {
      if (phoneArr[i].getOwner().equals(owner)){
        ownerPhones[place]= new SmartPhone(phoneArr[i]);
        place+=1;
      }
    }

    double minPrice = ownerPhones[0].getPrice();
    SmartPhone minPhone = new SmartPhone(ownerPhones[0]);
    for (int i = 1; i < place; i++) {
      if (ownerPhones[i].getPrice() < minPrice) {
        minPrice = ownerPhones[i].getPrice();
        minPhone = ownerPhones[i];
      }
    }

    return minPhone;
  }

  //             ---------------------- BET 8) ----------------------
  public static void del(SmartPhone[] phoneArr) {
    System.out.println("enter name of app to delete");
    String appToDel = in.next();
    for (SmartPhone smartPhone : phoneArr) {
      if (smartPhone.isInside(appToDel)) smartPhone.removeApplication(appToDel);
    }
  }

  //             ---------------------- BET 9) ----------------------

  public static void add(SmartPhone[] phoneArr) {
    System.out.println("enter name of app to add");
    String appToAdd = in.next();
    System.out.println("Enter id to add app to, when id=0 is stop");
    String id = in.next();
    while (!id.equals("0")) {
      for (SmartPhone smartPhone : phoneArr) {
        if (smartPhone.getOwner().equals(id)) {
          smartPhone.addApplication(appToAdd);
          // break;
        }
      }
      System.out.println("Enter Next");
      id = in.next();
    }
  }

  //            ------------------------helpers!------------------------

  // in order to get date input from user for phone
  public static Date nextDate() {
    System.out.println("(Date), Enter: int Year, int month, int day in month");
    int Year = in.nextInt();
    int Month = in.nextInt() + 1; // because Jan is index 0...
    int Date = in.nextInt();
    return new Date(Year, Month, Date); //deprecated (Date)
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

  public static void push(int[] arr, int num) {

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -999) {
        arr[i] = num;
        return;
      }
    }
  }
}
