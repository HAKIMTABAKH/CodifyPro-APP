package com.example.porject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PythonMainFormation extends AppCompatActivity {
    ImageView fombgpy, iconplay1, iconplay5, iconplay2, iconplay4, iconplay3, iconplay6, courselistpy;
    Button btn_shop;
    CardView card, card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_python_main_formation);
        //declaration des variables
        btn_shop = findViewById(R.id.btn_shop);
        card = findViewById(R.id.card);
        card1 = findViewById(R.id.card1);
        fombgpy = findViewById(R.id.fombgpy);
        iconplay1 = findViewById(R.id.iconplay1);
        iconplay5 = findViewById(R.id.iconplay5);
        iconplay2 = findViewById(R.id.iconplay2);
        iconplay4 = findViewById(R.id.iconplay4);
        iconplay3 = findViewById(R.id.iconplay3);
        iconplay6 = findViewById(R.id.iconplay6);
        courselistpy = findViewById(R.id.courselistpy);

        //actions methodes
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PythonMainFormation.this, PaymentForm.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
