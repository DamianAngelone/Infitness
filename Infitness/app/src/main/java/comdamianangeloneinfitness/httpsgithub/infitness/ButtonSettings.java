package comdamianangeloneinfitness.httpsgithub.infitness;

import android.content.SharedPreferences;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * Created by Damian on 2017-04-07.
 */



public class ButtonSettings extends AppCompatActivity
{
    public ToggleButton toggle;
    public ToggleButton toggle2;
    public ToggleButton toggle3;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.getLayoutInflater().inflate(R.layout.settings_page, null);
        setContentView(R.layout.settings_page);
        SharedPreferences sharedPrefs =getSharedPreferences("comdamianangeloneinfitness.httpsgithub.infitness.ButtonSettings.java", MODE_PRIVATE);


        toggle = (ToggleButton) findViewById(R.id.foodButton);
        toggle2 = (ToggleButton) findViewById(R.id.fitnessButton);
        toggle3 = (ToggleButton) findViewById(R.id.pedometerButton);

        toggle.setChecked(sharedPrefs.getBoolean("toggle", true));
    }

    public void onClick(View v){

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("comdamianangeloneinfitness.httpsgithub.infitness.MainActivity.java", MODE_PRIVATE).edit();
                    editor.putBoolean("toggle", true);
                    MainActivity.setFood(true);
                    editor.commit();
                } else {
                    // The toggle is disabled
                    SharedPreferences.Editor editor = getSharedPreferences("comdamianangeloneinfitness.httpsgithub.infitness.MainActivity.java", MODE_PRIVATE).edit();
                    editor.putBoolean("toggle", false);
                    editor.commit();
                    MainActivity.setFood(false);
                }
            }
        });

        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setFitness(true);
                } else {
                    // The toggle is disabled
                    MainActivity.setFitness(false);
                }
            }
        });

        toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setPedometer(true);
                } else {
                    // The toggle is disabled
                    MainActivity.setPedometer(false);
                }
            }
        });
    }
}
