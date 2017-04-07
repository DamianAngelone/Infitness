package comdamianangeloneinfitness.httpsgithub.infitness;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class holds 7 data per day in a daily history. When data is not given for those days it assumes a preset 'typical' value
 *
 * Created by Liam on 2017-04-05.
 */

public class BasicRoutineData{

    private ArrayList<CompoundPoint> mRoutine = new ArrayList<CompoundPoint>();

    BasicRoutineData(){
        mRoutine = readRoutine();
    }

    ArrayList<CompoundPoint> getRoutine(){
        return mRoutine;
    }

    void setRoutine(ArrayList<CompoundPoint> routine) throws IOException {
        mRoutine = routine;
        writeRoutine(routine);
    }

    private ArrayList<CompoundPoint> readRoutine(){

        ArrayList<int[]> routineWithIntArrays = CSVParser.parseCSV("",8);
        ArrayList<CompoundPoint> lRoutine = new ArrayList<CompoundPoint>();

        for (int[] datum : routineWithIntArrays){
            CompoundPoint lCompoundPoint = new CompoundPoint(datum[0],datum[1],datum[2],datum[3],datum[4],datum[5],datum[6],datum[7]);
            lRoutine.add(lCompoundPoint);
        }

        return lRoutine;
    }

    private void writeRoutine(ArrayList<CompoundPoint> routine) throws IOException {

    	ArrayList<int[]> lWritableRoutine = new ArrayList<int[]>();

        for (CompoundPoint point : routine){
        	int[] pointArray = new int[8];
        	pointArray[0]= point.time;
        	pointArray[1]= point.calorie;
        	pointArray[2]= point.protein;
        	pointArray[3]= point.nutrients;
        	pointArray[4]= point.upper;
        	pointArray[5]= point.core;
        	pointArray[6]= point.lower;
        	pointArray[7]= point.cardio;

        	lWritableRoutine.add(pointArray);
        }

        CSVWriter.writeCSV(lWritableRoutine, "Routine.txt");
    }
}
