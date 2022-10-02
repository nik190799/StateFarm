package com.example.statefarm.ui.about_us;

import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.statefarm.R;
import com.example.statefarm.User;
import com.example.statefarm.databinding.FragmentSlideshowBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;


    EditText emailText,firstNameText,lastNameText,phoneText,zipcode;
    Button submitButton;
    DatabaseReference dbRef;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        emailText = root.findViewById(R.id.emailText);
        firstNameText = root.findViewById(R.id.firstNameText);
        lastNameText = root.findViewById(R.id.lastNameText);
        phoneText = root.findViewById(R.id.phoneText);
        zipcode = root.findViewById(R.id.zipcode);

        submitButton = root.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Insurance/Users");
                insertData();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void insertData(){

        String email = emailText.getText().toString();
        String first = firstNameText.getText().toString();
        String last = lastNameText.getText().toString();
        String phone = phoneText.getText().toString();
        String zip = zipcode.getText().toString();


        User user = new User(email,first,last,phone,zip);
        dbRef.push().setValue(user);

        Toast.makeText(getContext(),"Data Uploaded",Toast.LENGTH_LONG).show();
    }
}