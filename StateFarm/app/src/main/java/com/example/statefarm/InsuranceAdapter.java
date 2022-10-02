package com.example.statefarm;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView insuranceName, description, link;
        LinearLayout insuranceLayout,insuranceLayout1,insuranceLayout2;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            insuranceName = itemView.findViewById(R.id.insuranceHeader);
            description = itemView.findViewById(R.id.insuranceText);
            link = itemView.findViewById(R.id.insuranceLink);


            insuranceLayout = itemView.findViewById(R.id.insuranceLayout);
            insuranceLayout1 = itemView.findViewById(R.id.insuranceLayout1);
            insuranceLayout2 = itemView.findViewById(R.id.insuranceLayout2);
            insuranceLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

            insuranceLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int v = (insuranceLayout1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                    TransitionManager.beginDelayedTransition(insuranceLayout, new AutoTransition());
                    insuranceLayout1.setVisibility(v);
                }
            });

            description.setClickable(true);
            description.setMovementMethod(LinkMovementMethod.getInstance());





        }
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

        //String text = String.format("<a href='www.google.com'> Learn More...</a>", i.getLink());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }





}
