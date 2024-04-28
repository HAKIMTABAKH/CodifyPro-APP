package com.example.porject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;


public class profilio extends AppCompatActivity {
    Toolbar toolbar;
    ImageView icon1,icon2,icon3,icon4,icon5;
    TextView text1,text2,text3,text4,text5,flesh1,flesh2,flesh3,flesh4,flesh5;

    ImageView arrow_icon,setting_icon;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profilio);
        //declarations des variables
        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
        icon4 = findViewById(R.id.icon4);
        icon5 = findViewById(R.id.icon5);

        text1 =findViewById(R.id.text1);
        text2 =findViewById(R.id.text2);
        text3 =findViewById(R.id.text3);
        text4 =findViewById(R.id.text4);
        text5 =findViewById(R.id.text5);

        flesh1 =findViewById(R.id.flesh1);
        flesh2 =findViewById(R.id.flesh2);
        flesh3 =findViewById(R.id.flesh3);
        flesh4 =findViewById(R.id.flesh4);
        flesh5 =findViewById(R.id.flesh5);

        mAuth = FirebaseAuth.getInstance();
        toolbar = findViewById(R.id.toolbar1);
        arrow_icon = findViewById(R.id.arrow_icon);
        setting_icon = findViewById(R.id.setting_icon);

        //actions methodes
        arrow_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilio.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        flesh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                signOutUser();
                Toast.makeText(profilio.this, "Please log in to access the application", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void signOutUser() {
        Intent mainActivity = new Intent(profilio.this, Login.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
        finish();
    }
}