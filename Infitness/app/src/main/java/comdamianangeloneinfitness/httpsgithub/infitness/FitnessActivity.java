package comdamianangeloneinfitness.httpsgithub.infitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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

        makeGraph();
    }

    public void makeGraph(){

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(1, 4),
                new DataPoint(2, 2),
                new DataPoint(3, 5),
                new DataPoint(4, 6)
        });
        graph.addSeries(series2);

        series.setTitle("Series1");
        series2.setTitle("Series2");
        /*series2.setTitle("Series3");
        series2.setTitle("Series4");
        series2.setTitle("Series5");
        series2.setTitle("Series6");
        series2.setTitle("Series7");*/
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }
}
