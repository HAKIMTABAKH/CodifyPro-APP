package com.example.porject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentForm extends AppCompatActivity {
    TextView textView,titre2,textView8,textView9,textView10,texttoolbar;
    //Toolbar toolbar2;
    ImageView arrow_icon,imageView2;
    EditText editTextNumberDecimal,editText,editText2;
    Button btn_pay;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_form);

        //declations de variables

        textView = findViewById(R.id.textView);
        titre2 = findViewById(R.id.titre2);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        imageView2 = findViewById(R.id.imageView2);

        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        texttoolbar = findViewById(R.id.texttoolbar);
        //toolbar2 = findViewById(R.id.toolbar2);
        arrow_icon = findViewById(R.id.arrow_icon);

        switch1 = findViewById(R.id.switch1);
        btn_pay = findViewById(R.id.btn_pay);

        //actions methodes
        arrow_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentForm.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentForm.this, "You should Fill All Fileds", Toast.LENGTH_SHORT).show();
            }
        });



    }
}