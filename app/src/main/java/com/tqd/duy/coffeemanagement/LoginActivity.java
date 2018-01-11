package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tqd.duy.models.User;
import java.util.ArrayList;

/**
 * Created by Danh on 12/12/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText txtUserName;
    private EditText txtUserPassword;
    private Button btnLogin;
    private ArrayList<User> listUser;
    private TextView txtNotification;
    private CheckBox chkPasswordRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        for (User user : listUser) {
            if (userName.equalsIgnoreCase(user.getUserName())) {
                if (!userPass.equals(user.getUserPassword())) {
                    txtNotification.setText(R.string.user_error);
                    Toast.makeText(LoginActivity.this, R.string.user_error,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, R.string.login_success,
                            Toast.LENGTH_SHORT).show();
                    checkPasswordRemember();
                    openMainActivity();
                }
            } else {
                txtNotification.setText(R.string.user_error);
                Toast.makeText(LoginActivity.this, R.string.user_error,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void openMainActivity() {
        Intent it = new Intent(LoginActivity.this, TableActivity.class);
        startActivity(it);
        finish();
    }
    private void addControls() {
        txtUserName = findViewById(R.id.login_screen_txt_user_name);
        txtUserPassword = findViewById(R.id.login_screen_txt_user_password);
        btnLogin = findViewById(R.id.login_screen_btn_login);
        txtNotification = findViewById(R.id.login_screen_txt_notification);
        listUser = new ArrayList<>();
        User user = new User();
        listUser = user.getSampleUser();
        chkPasswordRemember = findViewById(R.id.activity_login_chk_password_remember);
        //Set data login nếu đã login từ trước
        SharedPreferences sharedPreferences = getSharedPreferences("userRemember",
                MODE_PRIVATE);
        Boolean isCheck = sharedPreferences.getBoolean("isCheck",false);
        if (isCheck) {
            String name = sharedPreferences.getString("userName", "");
            String pass = sharedPreferences.getString("userPass", "");
            txtUserName.setText(name);
            txtUserPassword.setText(pass);
        }
    }
    //Lưu data login nếu check nhớ pass
    private void checkPasswordRemember() {
        SharedPreferences sharedPreferences = getSharedPreferences("userRemember",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", txtUserName.getText().toString());
        editor.putString("userPass", txtUserPassword.getText().toString());
        editor.putBoolean("isCheck",chkPasswordRemember.isChecked());
        editor.apply();
    }
}