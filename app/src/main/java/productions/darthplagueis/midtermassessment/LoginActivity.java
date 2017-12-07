package productions.darthplagueis.midtermassessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    private EditText username;
    private EditText password;
    private CheckBox rememberMe;
    private Button submitButton;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_edittext01);
        password = (EditText) findViewById(R.id.login_edittext02);
        rememberMe = (CheckBox) findViewById(R.id.login_checkbox);
        submitButton = (Button) findViewById(R.id.login_button);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        buttonSetUp();
    }

    private void buttonSetUp() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();
                if (rememberMe.isChecked()) {
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", rememberMe.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", rememberMe.isChecked());
                    editor.commit();
                }

                String checkUser = "user@aol.com";
                String checkPassword = "password1234";

                if (username.getText().toString().equalsIgnoreCase(checkUser)
                        && password.getText().toString().equals(checkPassword)) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("currentUser", username.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Login. Pleast try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
