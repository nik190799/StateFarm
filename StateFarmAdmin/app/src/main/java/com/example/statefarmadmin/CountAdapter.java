package com.example.statefarmadmin;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountAdapter extends RecyclerView.Adapter<CountAdapter.MyViewHolder> {


    Context context;
    ArrayList<GetCount> list;



    public CountAdapter(Context context, ArrayList<GetCount> list) {
        this.context = context;
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView atvCount,boatCount,carCount,disabilityCount,healthCount,homeCount,liabilityCount,lifeCount,motorCount,petCount,rsaCount,rvCount,sbCount;




        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            atvCount = itemView.findViewById(R.id.atvCount);
            boatCount = itemView.findViewById(R.id.boatCount);
            carCount = itemView.findViewById(R.id.carCount);
            disabilityCount = itemView.findViewById(R.id.disabilityCount);
            healthCount = itemView.findViewById(R.id.healthCount);
            homeCount = itemView.findViewById(R.id.homeCount);
            liabilityCount = itemView.findViewById(R.id.liabilityCount);
            lifeCount = itemView.findViewById(R.id.lifeCount);
            motorCount = itemView.findViewById(R.id.motorCount);
            petCount = itemView.findViewById(R.id.petCount);
            rsaCount = itemView.findViewById(R.id.rsaCount);
            rvCount = itemView.findViewById(R.id.rvCount);
            sbCount = itemView.findViewById(R.id.sbCount);

        }
    }

    @NonNull
    @Override
    public CountAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.get_count_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountAdapter.MyViewHolder holder, int position) {

        GetCount i = list.get(position);
//        holder.insuranceName.setText(i.getInsuranceName());
//        holder.description.setText(i.getDescription());
        holder.atvCount.setText(String.valueOf(i.getAtv()));
        holder.boatCount.setText(String.valueOf(i.getBoat()));
        holder.carCount.setText(String.valueOf(i.getCar()));
        holder.disabilityCount.setText(String.valueOf(i.getDisability()));
        holder.healthCount.setText(String.valueOf(i.getHealth()));
        holder.homeCount.setText(String.valueOf(i.getHome()));
        holder.liabilityCount.setText(String.valueOf(i.getLiability()));
        holder.lifeCount.setText(String.valueOf(i.getLife()));
        holder.motorCount.setText(String.valueOf(i.getMotorCycle()));
        holder.petCount.setText(String.valueOf(i.getPet()));
        holder.rsaCount.setText(String.valueOf(i.getRsa()));
        holder.rvCount.setText(String.valueOf(i.getRv()));
        holder.sbCount.setText(String.valueOf(i.getSmallBuisness()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}
