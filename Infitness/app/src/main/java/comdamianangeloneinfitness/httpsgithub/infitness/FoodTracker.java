package comdamianangeloneinfitness.httpsgithub.infitness;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.*;

import comdamianangeloneinfitness.httpsgithub.infitness.FoodTrackerFlyOut;


/**
 * Created by Viraj Patel on 2017-04-06.
 */

public class FoodTracker extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate((R.layout.food_tracker), null);
        setContentView(R.layout.food_tracker);
        Button foodTrackerSideMenu = (Button)findViewById(R.id.button2);
        foodTrackerSideMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(FoodTracker.this, FoodTrackerOpener.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        MainActivity.setState(false);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void toggleMenu(View v){
        this.toggleMenu(v);
    }
}
