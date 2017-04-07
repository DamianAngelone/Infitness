package comdamianangeloneinfitness.httpsgithub.infitness;

import java.util.Calendar;

/**
 * Created by Liam on 2017-04-05.
 */

public class Clock {

    Calendar calendar = new Calendar() {
        @Override
        protected void computeTime() {

        }

        @Override
        protected void computeFields() {

        }

        @Override
        public void add(int i, int i1) {

        }

        @Override
        public void roll(int i, boolean b) {

        }

        @Override
        public int getMinimum(int i) {
            return 0;
        }

        @Override
        public int getMaximum(int i) {
            return 0;
        }

        @Override
        public int getGreatestMinimum(int i) {
            return 0;
        }

        @Override
        public int getLeastMaximum(int i) {
            return 0;
        }
    };

     int getDate(){
         int day = calendar.get(Calendar.DAY_OF_YEAR);
         int year = calendar.get(Calendar.YEAR);

         //format int 2017245 for the 245th day of 2017
         return 1000*year + day;
    }
}
