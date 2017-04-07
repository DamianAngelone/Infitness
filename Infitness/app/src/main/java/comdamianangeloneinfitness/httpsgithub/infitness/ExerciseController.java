package comdamianangeloneinfitness.httpsgithub.infitness;

import java.io.IOException;

/**
 * Created by Liam on 2017-04-05.
 */

public class ExerciseController extends Controller {

    Clock mClock = new Clock();
    String dataName = "exerciseHistory.csv";

    ExerciseController(){
        mData = CSVParser.parseCSV(dataName,5);
    }

    void addExercise(int upper, int core, int lower, int cardio){
        int[] tuple = {mClock.getDate(), upper, core, lower, cardio};
        mData.add(tuple);
        writeData();
    }

    void writeData(){
        try {
            CSVWriter.writeCSV(mData, dataName);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
