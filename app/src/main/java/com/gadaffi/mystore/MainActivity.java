package com.gadaffi.mystore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //registration and login
    EditText etName,etEmail, etPassword,etRegNo,etPhoneNumber;
    TextView tvregister;
    Button btnLogin;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etName=(EditText) findViewById(R.id.et_name);
        etEmail=(EditText) findViewById(R.id.et_email);
        etPassword=(EditText) findViewById(R.id.et_password);
        etRegNo=(EditText)findViewById(R.id.et_regno);
        etPhoneNumber=(EditText) findViewById(R.id.et_pnumber);
        btnLogin=(Button) findViewById(R.id.btn_login);
        tvregister=(TextView) findViewById(R.id.tv_register);

//        tvregister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
//                startActivity(i);
//            }
//        });
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_profile);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_rooms:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RoomsFragment()).commit();
                break;
            case R.id.nav_book:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BookFragment()).commit();
                break;
            case R.id.nav_executive:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ExecutiveFragment()).commit();
                break;
           case R.id.nav_about_us:
               Intent intent=new Intent(MainActivity.this,AboutUs.class);
               startActivity(intent);
               break;
            case R.id.nav_share:
                String shareBody="https://www.mystore.com";
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MyStore");
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(shareIntent.createChooser(shareIntent,("Share Using")));

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openRegister(View view) {
        Intent i=new Intent(MainActivity.this,RegisterActivity.class);
           startActivity(i);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        final TextInputLayout emailWrapper=(TextInputLayout)findViewById(R.id.emailWrapper);
        final TextInputLayout passwordWrapper=(TextInputLayout)findViewById(R.id.passwordWrapper);
        emailWrapper.setHint("Email");
        passwordWrapper.setHint("Password");

    }
}
