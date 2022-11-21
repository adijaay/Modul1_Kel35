package com.example.modul1_kel35;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsernameLogin, etPasswdLogin;
    private Button btnSignUpLogin, btnSignInLogin;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        login();
        register();
    }

    private void initView() {
        etUsernameLogin =
                findViewById(R.id.etUsernameLogin);
        etPasswdLogin =
                findViewById(R.id.etPasswdLogin);
        btnSignInLogin =
                findViewById(R.id.btnSignInLogin);
        btnSignUpLogin =
                findViewById(R.id.btnSignUpLogin);
    }
    private void register() {
        btnSignUpLogin.setOnClickListener(V -> {
            Intent reg = new Intent(this,
                    RegisterActivity.class);
            startActivity(reg);
            finish();}
        );
    }

    private Boolean validation() {
        username = etUsernameLogin.getText().toString();
        password = etPasswdLogin.getText().toString();
        if(username.isEmpty()){
            Toast.makeText(this, "Isikan username",
                    Toast.LENGTH_SHORT).show();
            Log.e("Validation","false");
            return false;
        }
        if(password.isEmpty()){
            Toast.makeText(this, "Isikan Password",
                    Toast.LENGTH_SHORT).show();
            Log.e("Validation","false");
            return false;
        }
        Log.e("Validation","true");
        return true;
    }
    private void login() {
//    btnSignInLogin.setOnClickListener(v -> actLogin());
    }

    public void actLogin(View v) {
        if (validation()) {
            if (loginData()) {
                Log.e("actLogin", "true");
                Intent main = new Intent(this,
                        MainActivity.class);
                startActivity(main);
                finish();
            } else {
                Log.e("actLogin", "false");
                Toast.makeText(this, "Login gagal",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private Boolean loginData(){
        username = "budiman";//xxxxx
        if (password.equals("budiman123")){
            Log.e("loginData", "true");
            return true;
        } else {
            Log.e("loginData", "false");
            return false;
        }
    }
}