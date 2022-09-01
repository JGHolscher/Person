import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    Scanner in = new Scanner(System.in);
    Calendar c = Calendar.getInstance();
    private String ID;
    private String fName;

    public Person(String ID, String fName, String lName, String title, int YOB) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.YOB = YOB;
    }

    private String lName;
    private String title;
    private int YOB;
    private int year;

    public String fullName() {
        return fName + " " +lName;
    }
    public String formalName() {
        return title +""+lName;
    }
    public int getAge() {
        return YOB - c.get(Calendar.YEAR);
    }
    public String getAge(int year) {
        return null;
    }
    //int YOB = SafeInput.getRangedInt(in, "Please enter birth year", 1940, 2000);
    String fileName = "";
    boolean more = true;
    Scanner fileNamein = new Scanner(System.in);

    ArrayList<String> People = new ArrayList<>();

    // User enter Persons information
        do {
        Scanner in = new Scanner(System.in);
        String person = "";


        //System.out.printf("%10s", person);

        ID = SafeInput.getNonZeroLenString(in, "Please enter ID Number") + ", ";
        person += ID;

        fName = SafeInput.getNonZeroLenString(in, "Please enter First Name") + ", ";
        person += fName;

        lName = SafeInput.getNonZeroLenString(in, "Please enter Last Name") + ", ";
        person += lName;


        title = SafeInput.getNonZeroLenString(in, "Please enter persons Title (Mr., Mrs., Ms., Dr., etc.)") + ", ";
        person += title;

        int Birthyear = SafeInput.getInt(in, "Please enter persons Birth Year");
        person += Birthyear;

        People.add(person);

        System.out.println("\n");
        System.out.println(People);

        more = SafeInput.getYNConfirm(in, "Would you like to enter another Person");
    }while(more);






    File workingDirectory = new File(System.getProperty("user.dir"));
    fileName = SafeInput.getNonZeroLenString(fileNamein, "Please enter file name (Don't include .txt)");
    Path file = Paths.get(workingDirectory.getPath() + "//src//"+fileName+".txt");

        try
    {

        OutputStream out =
                new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));


        for(String person : People )
        {
            writer.write(person, 0, person.length());
            writer.newLine();
        }
        writer.close();
        System.out.println("Data file written:" + fileName + ".txt");
    }
        catch (IOException e)
    {
        e.printStackTrace();
    }
}
