package com.fyp.appmaker.FragmentTemplate2;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.FragmentTemplate2Binding;

public class Template2Fragment extends Fragment {

    FragmentTemplate2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_template2, container, false);

        return binding.getRoot();


    }

}
