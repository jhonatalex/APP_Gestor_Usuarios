package com.example.evaluacionintermediamoduloiii;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static com.example.evaluacionintermediamoduloiii.R.layout.fragment_blank;


public class BlankFragment extends Fragment  {
    FragmentTransaction Transac;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(fragment_blank, container, false);

        Button BotonCancelar=(Button)view.findViewById(R.id.cancelar);

        BotonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();

            }
        });










        return view;
    }


}