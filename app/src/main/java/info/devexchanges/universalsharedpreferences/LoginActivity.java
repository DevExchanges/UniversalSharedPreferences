package info.devexchanges.universalsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zookey.universalpreferences.UniversalPreferences;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout userName;
    private TextInputLayout password;
    public final static String KEY_USER_NAME = "username";
    public final static String KEY_PASSWORD = "password";
    public final static String IS_LOGIN = "is_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //checking user is logged in?
        //if logged in, redirect user to main activity
        boolean isLoggedIn = UniversalPreferences.getInstance().get(IS_LOGIN, false);
        if (isLoggedIn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_login);

            userName = (TextInputLayout) findViewById(R.id.username_field);
            password = (TextInputLayout) findViewById(R.id.password_field);
            View btnLogin = findViewById(R.id.btn_login);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userName.setError(null);
                    userName.setError(null);
                    if (!hasText(userName)) {
                        userName.setError("Please input your user name");
                    } else if (!hasText(password)) {
                        password.setError("Please input your user password");
                    } else {
                        //go to the main screen after store data in Universal SharedPreferences
                        UniversalPreferences.getInstance().put(KEY_USER_NAME, getText(userName));
                        UniversalPreferences.getInstance().put(KEY_PASSWORD, getText(password));
                        UniversalPreferences.getInstance().put(IS_LOGIN, true);

                        //Go to Main Activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private boolean hasText(TextInputLayout inputLayout) {
        return !inputLayout.getEditText().getText().toString().trim().equals("");
    }

    private String getText(TextInputLayout inputLayout) {
        return inputLayout.getEditText().getText().toString().trim();
    }
}
