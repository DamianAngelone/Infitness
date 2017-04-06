package comdamianangeloneinfitness.httpsgithub.infitness;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;
import butterknife.Bind;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import java.util.*;

public class Login extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Users");

    private UserProfile user;

    private static final String TAG = "Login";
    private static final int REQUEST_SIGNUP = 0;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference ref = firebaseDatabase.getReference("Users");
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_login) Button _loginButton;
    @Bind(R.id.link_signup) TextView _signupLink;

    private EditText userEmail;
    private EditText userPassword;

    ArrayList<String> existingEmails = new ArrayList<>();
    ArrayList<String> existingPassword = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        /*
        userEmail = (EditText)findViewById(R.id.input_email);
        String email = userEmail.getText().toString();

        userPassword = (EditText)findViewById(R.id.input_password);
        String password = userPassword.getText().toString();
        */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //ref.push().child("Username").setValue("Damian");

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //finish();
                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Login.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        user = new UserProfile();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here

                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    ///////////////////Check Duplicate Account////
    public void UserRetrieve(){
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                collectUserInfo((Map<String,User>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // return Usergroup;
    }

    private void collectUserInfo(Map<String,User> users) {

        existingEmails.clear();
        existingPassword.clear();
        //iterate through each user, ignoring their UID
        for (Map.Entry<String, User> entry : users.entrySet()){
            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            existingEmails.add((String) singleUser.get("email"));
            existingPassword.add((String) singleUser.get("password"));
        }
    }

    private boolean FoundUser(String username, String password){
        for(int i = 0; i< existingEmails.size(); i++) {
            if(username.equals(existingEmails.get(i))&& password.equals(existingPassword.get(i))) {

                user.email = (String)(existingEmails.get(i));
                user.password = (String)(existingEmails.get(i));
                return true;
            }
        }
        return false;

    }
}