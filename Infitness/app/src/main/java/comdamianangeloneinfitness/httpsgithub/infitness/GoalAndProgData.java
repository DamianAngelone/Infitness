package comdamianangeloneinfitness.httpsgithub.infitness;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Liam on 2017-04-05.
 */

public class GoalAndProgData{

    Clock mClock = new Clock();
    //7 values of goal are biweekly recommendations for each of: (calorie, protein, nutrient, upper, core, lower, cardio)
    int[] mGoal = new int[8];

    //setGoal must be called before getPerformance
    void setGoal(int calorie, int protein, int nutrient, int upper, int core, int lower, int cardio) throws IOException {
        
        mGoal[0] = mClock.getDate();
        mGoal[2] = protein;
        mGoal[3] = nutrient;
        mGoal[1] = calorie;
        mGoal[4] = upper;
        mGoal[5] = core;
        mGoal[6] = lower;
        mGoal[7] = cardio;

        writeGoal();
    }

    int[] getPerformance(ArrayList<CompoundPoint> routine){
        
        int[] lPerformance = new int[3];

        //sample equation for performance here
        ArrayList<CompoundPoint> lastTwoWeeks = new ArrayList<CompoundPoint>();
        //finds each point in the last two weeks
        for (CompoundPoint point : routine){
        	if(point.time >= mClock.getDate() - 14){
        		lastTwoWeeks.add(point);
        	}
        }
        //takes the average of the goal reached per day, assuming days without data are relatively consistent
        for (CompoundPoint point : lastTwoWeeks){
        	//integer division is intentional. Rounding is fine after changed to percentage by x100
        	//takes percentage of daily goal met where 50% is int 50
        	point.calorie = (100*point.calorie)/mGoal[1];
        	point.protein = (100*point.protein)/mGoal[2];
        	point.nutrients = (100*point.nutrients)/mGoal[3];
        	point.upper = (100*point.upper)/mGoal[4];
        	point.core = (100*point.core)/mGoal[5];
        	point.lower = (100*point.lower)/mGoal[6];
        	point.cardio = (100*point.cardio)/mGoal[7];

        	//in this equation, each factor is weighted the same
        	//broken into nutrient, exercise performance and overall progress
        	lPerformance[0] += (point.calorie + point.protein + point.nutrients)/3;
        	lPerformance[1] += (point.upper + point.core + point.lower + point.cardio)/4;
        }
        lPerformance[0] = lPerformance[0]/lastTwoWeeks.size();
        lPerformance[1] = lPerformance[1]/lastTwoWeeks.size();

        //overall progress is neglected for now
        lPerformance[2] = 60;

        return lPerformance;
    }

    private void readGoal(){

    	ArrayList<int[]> lGoalMonoarray = CSVParser.parseCSV("Routine.txt", 8);
    	mGoal = lGoalMonoarray.get(0);
    }

    private void writeGoal() throws IOException {

    	ArrayList<int[]> lGoalMonoarray = new ArrayList<int[]>();
    	lGoalMonoarray.add(mGoal);
    	CSVWriter.writeCSV(lGoalMonoarray, "Routine.txt");
    }
}
