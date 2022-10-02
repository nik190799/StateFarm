package com.example.statefarmadmin.ui.dashboard;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.statefarmadmin.CountAdapter;
import com.example.statefarmadmin.GetCount;
import com.example.statefarmadmin.R;
import com.example.statefarmadmin.databinding.FragmentDashboardBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    DatabaseReference database;

    RecyclerView recyclerView;
    ArrayList<GetCount> list;
    CountAdapter adapter;

    //TextView atvCount,boatCount,carCount,disabilityCount,healthCount,homeCount,liabilityCount,lifeCount,motorCount,petCount,rsaCount,rvCount,sbCount;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);



        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.getCountRecycler);
        database = FirebaseDatabase.getInstance().getReference("Insurance/Count");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<GetCount>();
        adapter = new CountAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

//        atvCount = root.findViewById(R.id.atvCount);
//        boatCount = root.findViewById(R.id.boatCount);
//        carCount = root.findViewById(R.id.carCount);
//        disabilityCount = root.findViewById(R.id.disabilityCount);
//        healthCount = root.findViewById(R.id.healthCount);
//        homeCount = root.findViewById(R.id.homeCount);
//        liabilityCount = root.findViewById(R.id.liabilityCount);
//        lifeCount = root.findViewById(R.id.lifeCount);
//        motorCount = root.findViewById(R.id.motorCount);
//        petCount = root.findViewById(R.id.petCount);
//        rsaCount = root.findViewById(R.id.rsaCount);
//        rvCount = root.findViewById(R.id.rvCount);
//        sbCount = root.findViewById(R.id.sbCount);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetCount i = snapshot.getValue(GetCount.class);
                    list.add(i);
                }
                //Toast.makeText(getContext(),String.valueOf(list.size()),Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}