package com.lamnt.foodorder.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.common.Key;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.auth.LoginFragment;
import com.lamnt.foodorder.view.fragment.auth.RegisterFragment;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initFragments();
    }

    private void initFragments() {
        String type = getIntent().getStringExtra(Key.SimpleKey.TYPE);
        if (Key.Action.LOGIN.equals(type)) {
            loadFragment(new LoginFragment());
        } else {
            loadFragment(new RegisterFragment());
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentUtil.replaceFragment(this, R.id.login_container, fragment, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.login_container);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
