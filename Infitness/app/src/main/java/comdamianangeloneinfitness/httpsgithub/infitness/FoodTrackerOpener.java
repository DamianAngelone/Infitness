package comdamianangeloneinfitness.httpsgithub.infitness;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import comdamianangeloneinfitness.httpsgithub.infitness.FoodTrackerFlyOut;

public class FoodTrackerOpener extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.food_trackersidemenu, null);

        setContentView(R.layout.food_trackersidemenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void toggleMenu(View v){
        this.toggleMenu(v);
    }
}
