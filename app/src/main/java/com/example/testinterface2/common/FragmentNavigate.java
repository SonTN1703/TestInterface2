package com.example.testinterface2.common;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testinterface2.R;

public class FragmentNavigate {
    private static void addFragment(Activity activity, @NonNull Fragment fragment){
        ((AppCompatActivity) activity).getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.getClass().getSimpleName())
                .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.enter,R.anim.exit)
                .add(R.id.container,fragment,fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }
    public static void addNewFragment(Activity activity, @NonNull Fragment fragment) {
        AppCompatActivity appCompatActivity = (AppCompatActivity)activity;
        if (appCompatActivity.getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName())==null){
            addFragment(activity,fragment);
        }
    }
}
