import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


/**
 * Created by hemanth on 07/03/2016.
 */

public class Searchfile {
    public static void main(String[] args) throws IOException {

        //Delimiter used in CSV file
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        //CSV file header
        String FILE_HEADER = "word,frequency";


        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("/Users/hemanth/Documents/Cloudwick/textfile.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);


            String word = "";
            int val = 0;


                Scanner Sc = new Scanner(new File("/Users/hemanth/Documents/Cloudwick/pg2601.txt"));

                //
                int count = 0;
                int count2 = 0;
                int k = 0;
                ArrayList array1 = new ArrayList();
                ArrayList array2 = new ArrayList();
                ArrayList array3 = new ArrayList();
                while (Sc.hasNext()) {
                    array1.add(k, Sc.next());
                    k++;
                }
            array2=array1;
            for (int i = 0; i < array2.size(); i++) {
                for (int j=i+1;j < array2.size();j++) {

                    if(array2.get(i)==array2.get(j)) {
                        array2.add(i,0);
                    }
                }
                }
                for (int i = 0; i < array2.size(); i++) {
                    for (int j=0;j < array1.size();j++) {
                        if (array2.get(i) == array1.get(j)) {
                            count2++;
                        }
                    }
                    array3.add(i, count2);
                    fileWriter.append((String) array1.get(i));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(array3.get(i)));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}