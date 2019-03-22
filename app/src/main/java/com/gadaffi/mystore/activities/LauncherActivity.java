package com.gadaffi.mystore.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gadaffi.mystore.Constants;
import com.gadaffi.mystore.R;

public class  LauncherActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("childcare",MODE_PRIVATE);
        initFragment();
    }

    private void initFragment() {
        Fragment fragment;
        if (pref.getBoolean(Constants.IS_LOGGED_IN, false)) {
            Intent i = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(i);
        } else {
            fragment = new LoginFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, fragment);
            ft.commit();
        }

    }
}