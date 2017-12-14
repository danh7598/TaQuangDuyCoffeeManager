package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tqd.duy.models.User;
import com.tqd.duy.models.UserExample;
import java.util.ArrayList;

/**
 * Created by Danh on 12/12/2017.
 */

public class LoginScreen extends AppCompatActivity {
    private EditText txtUserName;
    private EditText txtUserPassword;
    private Button btnLogin;
    private ArrayList<User> dsUser;
    private TextView txtNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processLogin();
            }
        });

    }

    private void processLogin() {
        String userName = txtUserName.getText().toString();
        String userPass = txtUserPassword.getText().toString();
        for (User user : dsUser)
        {
            if(userName.equalsIgnoreCase(user.getUserName()))
            {
                if(!userPass.equals(user.getUserPassword()))
                {
                    txtNotification.setText(R.string.user_error);
                }
                else {
                    Toast.makeText(LoginScreen.this,R.string.login_success,
                            Toast.LENGTH_SHORT).show();
                    openMainActivity();
                }
            }
            else {
                txtNotification.setText(R.string.user_error);
            }
        }
    }

    private void openMainActivity() {
        Intent it = new Intent(LoginScreen.this,MainActivity.class);
        startActivity(it);
    }

    private void addControls() {
        txtUserName = findViewById(R.id.login_screen_txt_user_name);
        txtUserPassword = findViewById(R.id.login_screen_txt_user_password);
        btnLogin = findViewById(R.id.login_screen_btn_login);
        txtNotification = findViewById(R.id.login_screen_txt_notification);
        dsUser = new ArrayList<>();
        UserExample userExample1 = new UserExample(dsUser);
        userExample1.SetUserExample();
    }

}
