import java.util.*;

public class Person {
    String ID = "";
    String fName = "";
    String lName = "";
    String title = "";
    int YOB = 0;
    private static int startSeed = 0;

    public Person(int ID, String fName, String lName, String title, int YOB)
    {
        this.ID = String.valueOf(ID);
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        if(YOB>=1940 && YOB<=2000)
            this.YOB= YOB;
    }

    public Person(String fName, String lName, String title, int YOB) {
        startSeed++;
        this.ID = "00000" + startSeed;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.YOB = YOB;
    }

    public static void startSeed(int i) {
    }

    public static int startSeed() {
        return 0;
    }

    public String fullName(){
        return fName + " " + lName;
    }
    public String formalName(){
        return title + fullName();
    }

    public int getAge(){
        if(YOB>=1940 && YOB <=2000)
            return Calendar.getInstance().get(Calendar.YEAR) - YOB;
        return 0;
    }
    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSVDataRecord(){
        return this.ID + ", " + this.fName + ", " + this.lName + ", " + this.title + ", " + this.YOB + "\n";

    }




    public String getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = String.valueOf(ID);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }


    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

}

