package com.example.modul1_kel35;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.window.SplashScreen;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SplashInterval = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        handler();
    }
    private void handler(){
        new Handler().postDelayed(() -> {
            if (initPreference()){
                Intent main = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            } else {
                Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SplashInterval);
    }
    private Boolean initPreference() {
        SharedPreferences preferences =
                getSharedPreferences("LoginPreference", MODE_PRIVATE);
        String username =
                preferences.getString("username", "");
        if (username.isEmpty()) {
            return false;
        }
        return false;
    }
}