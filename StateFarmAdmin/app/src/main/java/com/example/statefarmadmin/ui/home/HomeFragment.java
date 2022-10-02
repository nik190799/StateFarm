package com.example.statefarmadmin.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.statefarmadmin.InsertData;
import com.example.statefarmadmin.R;
import com.example.statefarmadmin.databinding.FragmentHomeBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    EditText insuranceName;
    EditText insuranceDescription;
    EditText webLink;
    Spinner spinner;
    Button submitButton;
    DatabaseReference dbRef;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        insuranceName = root.findViewById(R.id.insuranceName);
        insuranceDescription = root.findViewById(R.id.insuranceDescription);
        webLink = root.findViewById(R.id.webLink);
        spinner = root.findViewById(R.id.spinner);
        submitButton = root.findViewById(R.id.submitButton);







        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Insurance/"+spinner.getSelectedItem().toString());
                if(insuranceName.getText() == null || insuranceDescription.getText() == null || webLink.getText() == null){
                    Toast.makeText(getContext(),"Please enter input!!!",Toast.LENGTH_LONG).show();
                }else {
                insertData();
                }
            }
        });

        return root;
    }

    private void insertData(){
        String header = insuranceName.getText().toString();
        String description = insuranceDescription.getText().toString();
        String  link = webLink.getText().toString();

        InsertData data = new InsertData(header,description,link);
        dbRef.push().setValue(data);

        Toast.makeText(getContext(),"Data Uploaded",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}