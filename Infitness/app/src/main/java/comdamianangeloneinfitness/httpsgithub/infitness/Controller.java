package comdamianangeloneinfitness.httpsgithub.infitness;

import java.util.ArrayList;

/**
 * Created by Liam on 2017-04-05.
 */

public abstract class Controller {

    ArrayList<int[]> mData;

    ArrayList<int[]> getData(){
        return mData;
    }

    void setData( ArrayList<int[]> data){
        mData = data;
    }
}
