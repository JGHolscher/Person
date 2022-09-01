import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    //Calendar c = Calendar.getInstance();
    String ID;
    String fName;
    String lName;
    String title;
    int YOB;
    private int year;
    static private int startSeed = 1;

    public static void setStartSeed(int startSeed) {PersonGenerator.startSeed = startSeed;}
    public static int getStartSeed() {return startSeed;}

    public PersonGenerator(String ID, String fName, String lName, String title, int YOB) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
        return "PersonGenerator{" +
                "ID='" + ID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                ", year=" + year +
                '}';
    }
}