package com.example.statefarmadmin;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {


    Context context;
    ArrayList<User> list;



    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView emailText,firstNameText,lastNameText,phoneText,zipcodeText;



        public MyViewHolder(@NonNull View itemView){
            super(itemView);


            emailText = itemView.findViewById(R.id.emailText);
            firstNameText = itemView.findViewById(R.id.firstNameText);
            lastNameText = itemView.findViewById(R.id.lastNameText);
            phoneText = itemView.findViewById(R.id.phoneText);
            zipcodeText = itemView.findViewById(R.id.zipcodeText);



        }
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        User i = list.get(position);

        holder.emailText.setText(i.getEmail());
        holder.firstNameText.setText(i.getFirstName());
        holder.lastNameText.setText(i.getLastName());
        holder.phoneText.setText(String.valueOf(i.getPhone()));
        holder.zipcodeText.setText(String.valueOf(i.getZipcode()));



        //String text = String.format("<a href='www.google.com'> Learn More...</a>", i.getLink());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }





}