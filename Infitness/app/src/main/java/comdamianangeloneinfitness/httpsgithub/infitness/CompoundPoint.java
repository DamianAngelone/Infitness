package comdamianangeloneinfitness.httpsgithub.infitness;

/**
 * These points are specifically for the GoalAnalyzer, which needs points for both fitness and diet
 *
 * Created by Liam on 2017-04-05.
 */

public class CompoundPoint {

    int time;

    int calorie;
    int protein;
    int nutrients;

    int upper;
    int core;
    int lower;
    int cardio;

    CompoundPoint(int pTime, int pCalorie, int pProtein, int pNutrients, int pUpper, int pCore, int pLower, int pCardio){

        time = pTime;

        calorie = pCalorie;
        protein = pProtein;
        nutrients = pNutrients;

        upper = pUpper;
        core = pCore;
        lower = pLower;
        cardio = pCardio;
    }
}
