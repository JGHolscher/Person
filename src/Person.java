import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Person {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";

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

            int YOB = SafeInput.getInt(in, "Please enter persons Birth Year");
            person += YOB;

            People.add(person);

            System.out.println("\n");

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
}
