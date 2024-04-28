package com.example.porject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SignUp extends AppCompatActivity {
    EditText signupname,signupphone,signuppassword,signupemail,signupconpassword;
    TextView signuptext,loginRedirectText;
    Button signupbutton;

    //create object from databaseRefrences class to accses firebase's realtime database
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-8c120-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        signupname=findViewById(R.id.signupname);
        signupphone=findViewById(R.id.signupphone);
        signuppassword=findViewById(R.id.signuppassword);
        signupconpassword=findViewById(R.id.signupconpassword);
        signupemail=findViewById(R.id.signupemail);

        signuptext=findViewById(R.id.signuptext);
        loginRedirectText=findViewById(R.id.loginRedirectText);

        signupbutton=findViewById(R.id.signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //geting data from edittext
                String Signupname = signupname.getText().toString();
                String Signupemail = signupemail.getText().toString();
                String Signuppassword = signuppassword.getText().toString();
                String Signupconpassword = signupconpassword.getText().toString();
                String Signupphone = signupphone.getText().toString();

                //check if user fill all the files before sending data
                if (Signupname.isEmpty() || Signupemail.isEmpty() || Signuppassword.isEmpty() ||
                Signupphone.isEmpty() || Signupconpassword.isEmpty() ) {
                    Toast.makeText(SignUp.this, "please fill all fileds", Toast.LENGTH_SHORT).show();

                    //check if passwords are matching
                    //if not matching with each other then show a toast message
                }else if (!Signuppassword.equals(Signupconpassword)){
                    Toast.makeText(SignUp.this , "Passwords are not matching",Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if username is not registed before
                            if (snapshot.hasChild(Signupname)){
                                Toast.makeText(SignUp.this,"Username is already registered" ,Toast.LENGTH_SHORT).show();
                            }else {
                                //sending data to firebase realtime  database
                                databaseReference.child("users").child(Signupname).child("email").setValue(Signupemail);
                                databaseReference.child("users").child(Signupname).child("password").setValue(Signuppassword);
                                databaseReference.child("users").child(Signupname).child("phone").setValue(Signupphone);

                                Toast.makeText(SignUp.this,"registered seccessfully !" ,Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}