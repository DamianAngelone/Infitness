package comdamianangeloneinfitness.httpsgithub.infitness;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Liam on 2017-04-05.
 */

public class NutritionController extends Controller {

    Clock mClock = new Clock();
    String dataName = "mealHistory.csv";

    NutritionController(){
        mData = CSVParser.parseCSV(dataName,4);
    }

    void addMeal(int calorie, int protein, int nutrient){
        int[] meal = {mClock.getDate(), calorie, protein, nutrient};
        mData.add(meal);
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
