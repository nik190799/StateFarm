package com.example.statefarm.ui.insurance;

import android.animation.LayoutTransition;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.statefarm.R;


public class auto extends Fragment {

    //car card

    LinearLayout carLayout,carLayout1;
    CardView carCard;

    //motor card
    LinearLayout motorLayout,motorLayout1;
    CardView motorCard;

    //boat card

    LinearLayout boatLayout,boatLayout1;
    CardView boatCard;

    //atv card
    LinearLayout atvLayout,atvLayout1;
    CardView atvCard;


    //rv card
    LinearLayout rvLayout,rvLayout1;
    CardView rvCard;


    //rsa card
    LinearLayout rsaLayout,rsaLayout1;
    CardView rsaCard;

    public auto() {
        // Required empty public constructor
    }

    public static auto newInstance(String param1, String param2) {
        auto fragment = new auto();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);

        //car
        carLayout1 = view.findViewById(R.id.carLayout1);
        carLayout = view.findViewById(R.id.carLayout);
        carLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        carCard = view.findViewById(R.id.carCard);

        carCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (carLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(carLayout, new AutoTransition());
                carLayout1.setVisibility(v);
            }
        });

        //motor
        motorLayout1 = view.findViewById(R.id.motorLayout1);
        motorLayout = view.findViewById(R.id.motorLayout);
        motorLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        motorCard = view.findViewById(R.id.motorCard);
        motorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (motorLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(motorLayout, new AutoTransition());
                motorLayout1.setVisibility(v);
            }
        });



        //boat
        boatLayout1 = view.findViewById(R.id.boatLayout1);
        boatLayout = view.findViewById(R.id.boatLayout);
        boatLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        boatCard = view.findViewById(R.id.boatCard);
        boatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (boatLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(boatLayout, new AutoTransition());
                boatLayout1.setVisibility(v);
            }
        });


        //atv
        atvLayout1 = view.findViewById(R.id.atvLayout1);
        atvLayout = view.findViewById(R.id.atvLayout);
        atvLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        atvCard = view.findViewById(R.id.atvCard);
        atvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (atvLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(atvLayout, new AutoTransition());
                atvLayout1.setVisibility(v);
            }
        });

        //rv
        rvLayout1 = view.findViewById(R.id.rvLayout1);
        rvLayout = view.findViewById(R.id.rvLayout);
        rvLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        rvCard = view.findViewById(R.id.rvCard);
        rvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (rvLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(rvLayout, new AutoTransition());
                rvLayout1.setVisibility(v);
            }
        });

        //rsa
        rsaLayout1 = view.findViewById(R.id.rsaLayout1);
        rsaLayout = view.findViewById(R.id.rsaLayout);
        rsaLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        rsaCard = view.findViewById(R.id.rsaCard);
        rsaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (rsaLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(rsaLayout, new AutoTransition());
                rsaLayout1.setVisibility(v);
            }
        });

        return view;
    }

}