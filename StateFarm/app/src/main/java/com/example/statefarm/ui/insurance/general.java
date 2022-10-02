package com.example.statefarm.ui.insurance;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statefarm.Insurance;
import com.example.statefarm.InsuranceAdapter;
import com.example.statefarm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class general extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference database;
    ArrayList<Insurance> list;
    InsuranceAdapter insuranceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general, container, false);


        recyclerView = view.findViewById(R.id.insuranceList);
        database = FirebaseDatabase.getInstance().getReference("Insurance/General");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<Insurance>();
        insuranceAdapter = new InsuranceAdapter(getActivity(), list);
        recyclerView.setAdapter(insuranceAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Insurance i = snapshot.getValue(Insurance.class);
                    list.add(i);
                }
                //Toast.makeText(getContext(),String.valueOf(list.size()),Toast.LENGTH_LONG).show();
                insuranceAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }
}