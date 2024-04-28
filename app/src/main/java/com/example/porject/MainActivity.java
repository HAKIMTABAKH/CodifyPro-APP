package com.example.porject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {

    ImageView imageView, profileImageView,img1,img2,img3,img4;
    TextView textViewGreeting, textViewCourseTitle, textViewCategories, textViewSeeAll,test;

    CardView cardView;
    ImageView[] images = {img1, img2, img3, img4};
    //Toolbar toolbar;
    ImageView menuicon;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Initialize views
        imageView = findViewById(R.id.imageView);
        profileImageView = findViewById(R.id.iconprofile);
        textViewGreeting = findViewById(R.id.textView2);
        textViewCourseTitle = findViewById(R.id.textView3);
        textViewCategories = findViewById(R.id.textView4);
        textViewSeeAll = findViewById(R.id.textView5);
        cardView = findViewById(R.id.card);
        img1 =findViewById(R.id.img1);
        img2 =findViewById(R.id.img2);
        img3 =findViewById(R.id.img3);
        img4 =findViewById(R.id.img4);
        //toolbar = findViewById(R.id.toolbar);
        //menuicon = findViewById(R.id.menu_icon);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(MainActivity.this, profilio.class);
                startActivity(intnet);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, PythonMainFormation.class);
                startActivity(intent1);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, WebDesginFormation.class);
                startActivity(intent2);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, FlutterMainFormation.class);
                startActivity(intent3);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, JavaMainFormation.class);
                startActivity(intent4);
            }
        });

    }
}

