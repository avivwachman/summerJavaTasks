package summerWork;

import java.util.Arrays;
import java.util.Date;



            /*-----------------------------Q ONEa-----------------------------*/



public class SmartPhone {

        //initialize features
    private String owner;
    private double price;
    private int battery;
    private String[] application;
    private int current;
    private Date date;

        //constructor by features
    public SmartPhone(String newOwner, double newPrice, int battery, Date bought) {
        this.owner = newOwner;
        this.price = newPrice;
        this.battery = battery;
        this.date = bought;
        this.application = new String[100];
        this.current = 0;
    }

        //constructor by other SmartPhone (copy)
    public SmartPhone(SmartPhone other){              /*ask if need to use get!!!*/
        this.owner = other.getOwner();                  //what happens if we don't
        this.price = other.getPrice();
        this.battery = other.getBattery();
        this.date = other.getDate();
        this.application = other.getApplication();
        this.current = other.getCurrent();
    }

        //-----------------------------getters and setters [START]-----------------------------
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String[] getApplication() {
        return application;
    }

    public void setApplication(String[] application) {
        this.application = application;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  // -----------------------------getters and setters [END] -----------------------------

    @Override
    public String toString() {
        return "SmartPhone{" +
                "owner='" + owner + '\'' +
                ", price=" + price +
                ", battery=" + battery +
                ", application=" + Arrays.toString(application) +
                ", current=" + current +
                ", date=" + date + " "+ date.getYear()+
                '}';
    }



    // -----------------------------Application changes! -----------------------------


  public boolean isInside(String[] application, String check) { // does app already exist
      for (int i = 0; i < application.length; i++) {
          String s = application[i];
      if (s != null) {
        if (s.equals(check)) return true;
          }
      }
    return false;
    }


    //add app if we have enough space && don't have app yet
    public boolean addApplication(String newApplication){
        if (this.getCurrent()==100)
            return false;
        if (isInside(this.getApplication(), newApplication))
            return false;

        this.getApplication()[this.getCurrent()]= newApplication;
        this.setCurrent(this.getCurrent()+1);

        return true;
    }

  public void removeApplication(String appName) {
    String[] a = this.getApplication();

    for (int i = 0; i < a.length; i++) {
      if (a[i].equals(appName)) {
        a[i]=null;
        this.setCurrent(this.getCurrent() - 1);
        break;
      }
    }
    }
}
