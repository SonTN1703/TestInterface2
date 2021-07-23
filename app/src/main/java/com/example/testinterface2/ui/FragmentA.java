package com.example.testinterface2.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testinterface2.OnTextChangedListener;
import com.example.testinterface2.R;
import com.example.testinterface2.common.FragmentNavigate;

public class FragmentA extends BaseFragment implements OnTextChangedListener {

    private TextChangeViewmodel textChangeViewmodel;

    private static final String TAG = "FragmentA";
    public static FragmentA newInstance() {
        Bundle args = new Bundle();
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }
    private String a;

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textChangeViewmodel = ViewModelProviders.of(requireActivity()).get(TextChangeViewmodel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnGoB).setOnClickListener(v -> {
            FragmentB fragmentB = FragmentB.newInstance();
//            fragmentB.setOnTextChangedListener(this);
            FragmentNavigate.addNewFragment(mainActivity,fragmentB);
        });
        actions();
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_gallery;
    }

    @Override
    public void bindViews() {

    }

    @Override
    public void init() {

    }

    @Override
    public void actions() {
        textChangeViewmodel.getStringMutableLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onTextChanged1: "+s );
            }
        });
    }

    @Override
    public void onTextChanged(String s) {
        Log.e(TAG, "onTextChanged: "+s );
    }
}
