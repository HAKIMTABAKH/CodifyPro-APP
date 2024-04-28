package com.example.porject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity  {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-8c120-default-rtdb.firebaseio.com/");
    TextView username,signupRedirectText;
    EditText password;
    Button loginbutton;
    ImageView facebookicon,googleicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        //declation des variables
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        facebookicon = findViewById(R.id.facebookicon);
        googleicon = findViewById(R.id.googleicon);
        signupRedirectText=findViewById(R.id.signupRedirectText);

        loginbutton=findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();

                if (Username.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your name or your password !", Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if the username is exist in firebase
                            if (snapshot.hasChild(Username)){
                                //username exist
                                //getting password & match it with the user entred password
                                String getPassword = snapshot.child(Username).child("password").getValue(String.class);
                                if (getPassword.equals(Password)){
                                    Toast.makeText(Login.this,"Successfully Logged in !",Toast.LENGTH_SHORT).show();
                                    //open main activity
                                    Intent intent = new Intent(Login.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(Login.this,"Wrong Password !",Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(Login.this,"Wrong Password !",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open signup acitivity


                Intent intent = new Intent(Login.this , SignUp.class);
                startActivity(intent);
            }
        });
        facebookicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login to facebook
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/login/"));
                startActivity(intent);
            }
        });
        googleicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login to facebook
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AaSxoQz1KltnnEjzpr-6Au45rxEwEib6RaWnG2HBopVd0NcNO8pVi_tBwE2TcwV2j5rMvFDrMc43&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1039648752%3A1714171164064266&theme=mn&ddm=0"));
                startActivity(intent);
            }
        });
    }

}