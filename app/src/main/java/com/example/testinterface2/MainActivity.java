package com.example.testinterface2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testinterface2.common.FragmentNavigate;
import com.example.testinterface2.ui.FragmentA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStartFragment).setOnClickListener(v -> {
//            FragmentA fragmentA = new FragmentA();
//            fragmentA.setA(a);
//            FragmentA fragmentA1 = FragmentA.newInstance(a);
            FragmentA  fragmentA = FragmentA.newInstance();

            FragmentNavigate.addNewFragment(this,fragmentA);
        });
    }

}