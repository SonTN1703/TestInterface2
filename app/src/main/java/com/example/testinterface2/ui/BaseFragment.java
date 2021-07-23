package com.example.testinterface2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testinterface2.InitBase;
import com.example.testinterface2.MainActivity;

public abstract class BaseFragment extends Fragment implements InitBase {

    protected View view;
    protected MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(getLayoutResource(),container,false);
        mainActivity = (MainActivity) getActivity();
        return view;
    }

    protected abstract int getLayoutResource();
}
