package com.niranjan.schooladmin;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    // Bootonavigation
    Home home;
    Assignment assignment;
    Fees fees;
    Library library;
    NavigationView nav;
navHome navHome;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        home = new Home();
        assignment = new Assignment();
        fees = new Fees();
        library = new Library();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawer);
        bottomNavigationView = findViewById(R.id.bootambar);
        toolbar.setTitle("SchoolApplication");
        setfragment(home);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
Fragment temp;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homes:
                       temp = new navHome();
                        break;

                        case R.id.academicsession:
                            temp = new Academicsession();
                            break;
                    case R.id.rate:
                        temp = new Ratting();
                        break;
                    case R.id.detail:
                        temp = new Detail();
                        break;

                }
getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        setfragment(home);
                        break;
                    case R.id.assignment:
                        setfragment(assignment);
                        break;
                    case R.id.fees:
                        setfragment(fees);
                        break;
                    case R.id.library:
                        setfragment(library);
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

    }

    public void setfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}