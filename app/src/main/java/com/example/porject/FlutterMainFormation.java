package com.example.porject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FlutterMainFormation extends AppCompatActivity {
    ImageView javaformbg,iconplay1,iconplay5,iconplay2,iconplay4,iconplay3,iconplay6,courseformflutter;
    CardView card,card1;
    Button btn_shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flutter_main_formation);
        //declartion des varibales
        btn_shop = findViewById(R.id.btn_shop);
        card = findViewById(R.id.card);
        card1 = findViewById(R.id.card1);
        javaformbg = findViewById(R.id.javaformbg);
        iconplay1 = findViewById(R.id.iconplay1);
        iconplay5 = findViewById(R.id.iconplay5);
        iconplay2 = findViewById(R.id.iconplay2);
        iconplay4 = findViewById(R.id.iconplay4);
        iconplay3 = findViewById(R.id.iconplay3);
        iconplay6 = findViewById(R.id.iconplay6);
        courseformflutter = findViewById(R.id.courseformflutter);

        //actions methodes
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlutterMainFormation.this,PaymentForm.class);
                startActivity(intent);
                finish();
            }
        });
    }
}