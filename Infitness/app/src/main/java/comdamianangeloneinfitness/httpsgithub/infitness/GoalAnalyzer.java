package comdamianangeloneinfitness.httpsgithub.infitness;

import java.util.ArrayList;

public class GoalAnalyzer {

    Clock mClock = new Clock();
    BasicRoutineData mBasicRoutineData = new BasicRoutineData();
    GoalAndProgData mGoalAndProgData = new GoalAndProgData();

    NutritionController mNutritionController = new NutritionController();
    //ExerciseController mExerciseController = new ExerciseController();
    //WalkController mWalkController = new WalkController();

    //create the submodules, for each "data repo"
    GoalAnalyzer( ){ //NutritionTracker nutritionTracker, ExerciseTracker exerciseTracker, WalkTracker walkTracker
    }

    //returns %biweeklyRequirements being met for diet, exercise, and progress toward body goal
    int[] getPerformance(){
        return mGoalAndProgData.getPerformance(mBasicRoutineData.getRoutine());
    }

    //updates the basic history
    void update(){

        int lDate = mClock.getDate();
        ArrayList<CompoundPoint> lRoutine = mBasicRoutineData.getRoutine();

        //compares to last date recorded "YY365"
        //adds new point each day after
        int lLastDate = lRoutine.get(lRoutine.size() - 1).time;
        while(lLastDate < lDate){
            int calorie = 0, protein = 0, nutrient = 0, upper = 0, core = 0, lower = 0, cardio = 0;

            ArrayList<int[]> lNutrition = mNutritionController.getData();
            //ArrayList<int[]> lExercise = mExerciseController.getData();
            //ArrayList<int[]> lWalk = mWalkController.getData();

            for (int i=0; i < lNutrition.size();i++){
                if(lNutrition.get(i)[0] == lLastDate + 1){
                    calorie += lNutrition.get(i)[1];
                    protein += lNutrition.get(i)[2];
                    nutrient += lNutrition.get(i)[3];
                }
            }

//            for (int i=0; i < lExercise.size();i++){
//                if(lNutrition.get(i)[0] == lLastDate + 1){
//                    upper += lExercise.get(i)[1];
//                    core += lExercise.get(i)[2];
//                    lower += lExercise.get(i)[3];
//                    cardio += lExercise.get(i)[4];
//                }
//            }

//            for (int i=0; i < lWalk.size();i++){
//                if(lNutrition.get(i)[0] == lLastDate + 1){
//                    lower += lWalk.get(i)[1];
//                    cardio += lWalk.get(i)[2];
//                }
//            }

            lRoutine.add(new CompoundPoint(lLastDate + 1, calorie, protein, nutrient, upper, core, lower, cardio)); //

            lLastDate ++;
            //flips years
            if(lLastDate%1000 > 365){
                lLastDate = (lLastDate - lLastDate%1000);
            }
        }
    }
}
