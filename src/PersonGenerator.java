import javax.swing.*;
        import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
        import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";

        String fileName = "";
        boolean more = true;
        Scanner fileNamein = new Scanner(System.in);

        ArrayList<Person> People = new ArrayList<Person>();

        // User enter Persons information
        do {
            Scanner in = new Scanner(System.in);
           // ID = SafeInput.getNonZeroLenString(in, "Please enter ID Number");
            //p += ID;
            fName = SafeInput.getNonZeroLenString(in, "Please enter First Name");
           // p += fName;
            lName = SafeInput.getNonZeroLenString(in, "Please enter Last Name");
            //p += lName;
            title = SafeInput.getNonZeroLenString(in, "Please enter persons Title (Mr., Mrs., Ms., Dr., etc.)");
            //p += title;
            int YOB = SafeInput.getRangedInt(in, "Please enter persons Birth Year", 1940, 2000);
            //p += YOB;
            Person p = new Person(ID, fName, lName, title, YOB);
            more = SafeInput.getYNConfirm(in, "Would you like to enter another Person");
        }while(more);

        File workingDirectory = new File(System.getProperty("user.dir"));
        fileName = SafeInput.getNonZeroLenString(fileNamein, "Please enter file name");
        Path file = Paths.get(workingDirectory.getPath() + "//src//"+fileName+".txt");

        try
        {
            FileWriter writer = new FileWriter(fileName+".csv");

            //OutputStream out =
              //      new BufferedOutputStream(Files.newOutputStream(file, CREATE));
           // BufferedWriter writer =
              //      new BufferedWriter(new OutputStreamWriter(out));

            for(Person p : People ) {
                writer.write(p.toCSVDataRecord());
                //writer.write(person, 0, person.length());
                //writer.newLine();
            }

            writer.close();
            System.out.println("Data file written:" + fileName + ".csv");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
/*import javax.swing.*;
        import java.io.*;
import java.util.ArrayList;
        import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        JFileChooser chooser = new JFileChooser();
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";

        String fileName = "";
        boolean more = true;
        Scanner fileNamein = new Scanner(System.in);

        ArrayList<Person> People = new ArrayList<Person>();

        // User enter Persons information
       // do {
            Scanner in = new Scanner(System.in);


            ID = SafeInput.getNonZeroLenString(in, "Please enter ID Number") + ", ";
           ID = read.readLine();
            //p += ID;

            fName = SafeInput.getNonZeroLenString(in, "Please enter First Name") + ", ";
            fName = read.readLine();
            //p += fName;

            lName = SafeInput.getNonZeroLenString(in, "Please enter Last Name") + ", ";
            lName = read.readLine();
            //p += lName;


            title = SafeInput.getNonZeroLenString(in, "Please enter persons Title (Mr., Mrs., Ms., Dr., etc.)") + ", ";
            title = read.readLine();
            //p += title;

            int YOB = SafeInput.getRangedInt(in, "Please enter persons Birth Year",1960, 2000);
            YOB = Integer.parseInt(read.readLine());
            //p += YOB;
            //Person.add(p);
            Person p = new Person(ID, fName, lName, title, YOB);

            more = SafeInput.getYNConfirm(in, "Would you like to enter another Person");
       // }while(more);

        //File workingDirectory = new File(System.getProperty("user.dir"));
        fileName = SafeInput.getNonZeroLenString(fileNamein, "Please enter file name");
        //Path file = Paths.get(workingDirectory.getPath() + "//src//"+fileName+".csv");

        try
        {
            FileWriter writer = new FileWriter(fileName+".csv", more);
           // OutputStream out =
              //     new BufferedOutputStream(Files.newOutputStream(file, CREATE));
         //   BufferedWriter writer =
             //       new BufferedWriter(new OutputStreamWriter(out));


            for(Person p2 : People ) {
                writer.write(p2.toCSVDataRecord());
            }

            writer.close();
            System.out.println("Data file written:" + fileName + ".csv");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

 */