package com.lamnt.foodorder.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.fragment.intro.SplashFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_splash_container, new SplashFragment())
                .commit();
    }
}
