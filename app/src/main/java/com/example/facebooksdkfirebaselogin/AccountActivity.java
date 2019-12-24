package com.example.facebooksdkfirebaselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class AccountActivity extends AppCompatActivity {

    private Button logoutbutton;
    private FirebaseAuth mAuth;
    private ImageView profieImage;
    private TextView name,email,userid,userimageurl, firebaseidTextview;
    private UserPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        preferences = new UserPreferences(this);

        profieImage = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        userid = findViewById(R.id.userid);
        userimageurl = findViewById(R.id.imageurl);
        firebaseidTextview = findViewById(R.id.firebaseid);

        mAuth = FirebaseAuth.getInstance();
        logoutbutton = findViewById(R.id.logout);

        name.setText(preferences.getfirstname()+" "+preferences.getlastname());
        email.setText(preferences.getemailname());
        userid.setText(preferences.getuserid());
        userimageurl.setText(preferences.getuserimage());
        firebaseidTextview.setText(preferences.getfirebaseuserid());

        Picasso.get().load(preferences.getuserimage()).into(profieImage);

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                LoginManager.getInstance().logOut();
                preferences.removeuserdata();
                updateUI();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            updateUI();
        }


    }

    private void updateUI() {

        Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show();
        Intent a = new Intent(AccountActivity.this, MainActivity.class);
        startActivity(a);
        finish();

    }
}
