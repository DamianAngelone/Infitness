package comdamianangeloneinfitness.httpsgithub.infitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity{
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //DatabaseReference ref = firebaseDatabase.getReference("Fk me");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ref.setValue("fk u");

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    // Example of a call to a native method
   // TextView tv = (TextView) findViewById(R.id.sample_text);
    //tv.setText(stringFromJNI());
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
