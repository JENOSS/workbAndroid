package com.project.workmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    SalaryFragment salaryFragment;
    ContractFragment contractFragment;
    AttendanceFragment attendanceFragment;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contractFragment = new ContractFragment();
        salaryFragment = new SalaryFragment();
        attendanceFragment = new AttendanceFragment();

        setTitle("근로계약서");
        FragmentManager fragmentManager0 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction0 = fragmentManager0.beginTransaction();
        fragmentTransaction0.replace(R.id.fragment_container, contractFragment);
        fragmentTransaction0.commit();

        //use cookie
        SharedPreferences sf = getSharedPreferences("sFile",MODE_PRIVATE);
        String getUserid = sf.getString("userid","nop");
        Log.e("main",getUserid);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_contract:
                        setTitle("근로계약서");
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_container, contractFragment);
                        fragmentTransaction1.commit();
                        return true;
                    case R.id.navigation_attendance:
                        setTitle("출퇴근");
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_container, attendanceFragment);
                        fragmentTransaction2.commit();
                        return true;
                    case R.id.navigation_salary:
                        setTitle("급여");
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.fragment_container, salaryFragment);
                        fragmentTransaction3.commit();
                        return true;
                }
                return false;
            }
        });

//        salaryFragment = new Fragment();
//        contractFragment = new Fragment();
//        attendanceFragment = new Fragment();

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, salaryFragment).commit();

    }
}
