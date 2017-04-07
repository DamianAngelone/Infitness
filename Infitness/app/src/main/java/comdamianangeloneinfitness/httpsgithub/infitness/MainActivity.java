package comdamianangeloneinfitness.httpsgithub.infitness;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //DatabaseReference ref = firebaseDatabase.getReference("Fk me");
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private boolean isSensorPresent = false;
    private TextView mStepsSinceReboot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ref.setValue("fk u");

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

        mSensorManager = (SensorManager)  this.getSystemService(Context.SENSOR_SERVICE);
        Button clickButton = (Button) findViewById(R.id.walkController);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.pedometer_view);
                mStepsSinceReboot = (TextView) findViewById(R.id.steps);
                if(mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
                        != null)
                {
                    mSensor =
                            mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                    isSensorPresent = true;
                }
                else
                {
                    isSensorPresent = false;
                }


            }
        });

        Button nutrition = (Button)findViewById(R.id.NutritionTracker);
        nutrition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, FoodTracker.class));
            }
        });

        Button fitness = (Button)findViewById(R.id.ftinessRegimen);
        fitness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, FitnessActivity.class));
            }
        });

    // Example of a call to a native method
   // TextView tv = (TextView) findViewById(R.id.sample_text);
    //tv.setText(stringFromJNI());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isSensorPresent)
        {
            mSensorManager.registerListener(this, mSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isSensorPresent)
        {
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        mStepsSinceReboot.setText(String.valueOf(event.values[0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int integer) {


    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }

        else if (id == R.id.action_Sign_Out){

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            //finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
