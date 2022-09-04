
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.JFileChooser;




public class PersonReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line = "";

        Path target = new File(System.getProperty("user.dir")).toPath();
        System.out.println("Please select file you would like to view \n");
        System.out.printf("%-30s%-30s%-30s%-30s%-30s", "ID#", "Firstname", "Lastname", "Title", "YOB");
        System.out.println("\n=================================================================================================================================");

        target = target.resolve("src");

        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);

                while(inFile.hasNextLine()) {


                    line = inFile.nextLine();
                    String[] splitValues = line.split(", ");

                    System.out.printf("\n%-30s %-30s %-30s %-30s %-30s",splitValues[0], splitValues[1], splitValues[2], splitValues[3], splitValues[4]);
                }
                inFile.close();
            }
            else
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}

