package com.example.statefarm;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.statefarm.ui.insurance.general;

import java.util.ArrayList;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.MyViewHolder> {


    Context context;
    ArrayList<Insurance> list;
    public InsuranceAdapter(Context context, ArrayList<Insurance> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public InsuranceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.insurance_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceAdapter.MyViewHolder holder, int position) {

        Insurance i = list.get(position);
        holder.insuranceName.setText(i.getInsuranceName());
        holder.description.setText(i.getDescription());
        holder.link.setText(i.getLink());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView insuranceName, description, link;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            insuranceName = itemView.findViewById(R.id.insuranceHeader);
            description = itemView.findViewById(R.id.insuranceText);
            link = itemView.findViewById(R.id.insuranceLink);

        }
    }

}
