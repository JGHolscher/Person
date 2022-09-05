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
        String ID;
        String fName;
        String lName;
        String title;

        String fileName = "";
        boolean more = true;
        Scanner fileNamein = new Scanner(System.in);


        // User enter Persons information
        int YOB;

        ArrayList<Person> People = new ArrayList<Person>();
        do {
            Scanner in = new Scanner(System.in);

            fName = SafeInput.getNonZeroLenString(in, "Please enter First Name");

            lName = SafeInput.getNonZeroLenString(in, "Please enter Last Name");

            title = SafeInput.getNonZeroLenString(in, "Please enter persons Title (Mr., Mrs., Ms., Dr., etc.)");

            YOB = SafeInput.getRangedInt(in, "Please enter persons Birth Year", 1940, 2000);

            more = SafeInput.getYNConfirm(in, "Would you like to enter another Person");


            Person p = new Person(fName, lName, title, YOB);

            People.add(p);
            System.out.println(People);


        } while (more);


        File workingDirectory = new File(System.getProperty("user.dir"));
        fileName = SafeInput.getNonZeroLenString(fileNamein, "Please enter file name");
        Path file = Paths.get(workingDirectory.getPath() + "//src//" + fileName + ".txt");


        try {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (Person per : People) {
                // writer.write(per, 0, per.length());
                writer.write(per.toCSVDataRecord());
                // writer.newLine();
            }

            writer.close();
            System.out.println("Data file written:" + fileName + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
