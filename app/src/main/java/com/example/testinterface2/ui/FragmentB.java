package com.example.testinterface2.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testinterface2.OnTextChangedListener;
import com.example.testinterface2.R;

public class FragmentB extends BaseFragment {

    private TextChangeViewmodel textChangeViewmodel;

    private EditText editText;
//    private OnTextChangedListener onTextChangedListener;
//
//    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
//        this.onTextChangedListener = onTextChangedListener;
//    }

    public static FragmentB newInstance() {

        Bundle args = new Bundle();

        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textChangeViewmodel = ViewModelProviders.of(requireActivity()).get(TextChangeViewmodel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews();
        init();
        actions();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_slideshow;
    }

    @Override
    public void bindViews() {
        editText = view.findViewById(R.id.edtText);
    }

    @Override
    public void init() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textChangeViewmodel.setString(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void actions() {

    }
}
