package comdamianangeloneinfitness.httpsgithub.infitness;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Liam on 2017-04-05.
 */

public class CSVWriter {

    static void writeCSV(ArrayList<int[]> data, String fileName) throws IOException{

        FileWriter lFileWriter = new FileWriter(fileName);

        for (int[] datum : data){
            String line = "";
            for (int i=0; i<datum.length - 1; i++){
                line += datum[i];
                line += ",";
            }
            line += datum[datum.length - 1];
            lFileWriter.append(line);
        }

        lFileWriter.close();
    }
}
