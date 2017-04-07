package comdamianangeloneinfitness.httpsgithub.infitness;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Liam on 2017-04-05.
 */

public class CSVParser {

    static ArrayList<int[]> parseCSV(String fileName, int tupleLength) {

        ArrayList<int[]> lData = new ArrayList<int[]>();

        try {
            BufferedReader lBufferedReader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = lBufferedReader.readLine()) != null) {

                // use comma as separator
                String[] numbers = line.split(",");

                //possible array OOB exception
                int[] datum = new int[tupleLength];
                for(int i=0;i<tupleLength;i++){
                    datum[i] = Integer.parseInt(numbers[i]);
                }

                lData.add(datum);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return lData;
    }
}
