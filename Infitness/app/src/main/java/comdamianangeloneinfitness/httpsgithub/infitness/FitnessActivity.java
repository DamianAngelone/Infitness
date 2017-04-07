package comdamianangeloneinfitness.httpsgithub.infitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FitnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_fitness_view, null);

        setContentView(R.layout.activity_fitness_view);
        Button exerciseHistory = (Button)findViewById(R.id.button3);
        exerciseHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(FitnessActivity.this, ExerciseHistory.class));
            }
        });
        Button exerciseDataBase = (Button)findViewById(R.id.button4);
        exerciseDataBase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(FitnessActivity.this, ExerciseDataBase.class));
            }
        });
        Button exerciseTrend = (Button)findViewById(R.id.button5);
        exerciseTrend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(FitnessActivity.this, ExerciseTrend.class));
            }
        });
    }
}
