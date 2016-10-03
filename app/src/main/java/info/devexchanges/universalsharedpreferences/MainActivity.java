package info.devexchanges.universalsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zookey.universalpreferences.UniversalPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView userName = (TextView)findViewById(R.id.user_name_login);
        TextView password = (TextView)findViewById(R.id.password);
        View btnLogOut = findViewById(R.id.btn_logout);

        //get logged in user name and password in Universal SharedPreferences
        userName.setText(String.format("User name: %s", UniversalPreferences.getInstance().get(LoginActivity.KEY_USER_NAME, "")));
        password.setText(String.format("Password: %s", UniversalPreferences.getInstance().get(LoginActivity.KEY_PASSWORD, "")));

        //Logging out
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalPreferences.getInstance().clear();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}