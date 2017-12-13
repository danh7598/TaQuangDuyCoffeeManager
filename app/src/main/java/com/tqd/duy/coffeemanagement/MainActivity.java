package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.TableExample;
import com.tqd.duy.models.Table;
import com.tqd.duy.models.User;
import com.tqd.duy.models.UserExample;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


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

    private void addControls() {

        txtUserName = findViewById(R.id.login_screen_txt_user_name);
        txtUserPassword = findViewById(R.id.login_screen_txt_user_password);
        btnLogin = findViewById(R.id.login_screen_btn_login);
        txtNotification = findViewById(R.id.login_screen_txt_notification);
        dsUser = new ArrayList<>();
        UserExample userExample1 = new UserExample(dsUser);
        userExample1.SetUserExample();
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
                    Toast.makeText(MainActivity.this,R.string.login_success,
                            Toast.LENGTH_SHORT).show();
                }
            }
            else {
                txtNotification.setText(R.string.user_error);
            }
        }
    }
}
