package com.example.RestaurantMani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_In_Activity extends AppCompatActivity {

    EditText email1, password1;
    TextView wantToCreateAccount, facebook, googleplus;
    Button signInBtn;
    ImageView loginLogo;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        myDb = new DBHelper(this);
        email1 = (EditText)findViewById(R.id.email1);
        password1 = (EditText)findViewById(R.id.password1);
        wantToCreateAccount = (TextView)findViewById(R.id.wantToCreateAccount);
        signInBtn = (Button)findViewById(R.id.signInBtn);
        facebook = (TextView)findViewById(R.id.facebook);
        googleplus = (TextView)findViewById(R.id.googleplus);
        loginLogo = (ImageView)findViewById(R.id.loginLogo);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaili = email1.getText().toString();
                String passi = password1.getText().toString();
                Boolean checkEmailPassword = myDb.emailPassword(emaili,passi);
                if(checkEmailPassword==true){
                    Toast.makeText(Sign_In_Activity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Sign_In_Activity.this, FoodActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Sign_In_Activity.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        wantToCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_In_Activity.this, Sign_Up_Activity.class);
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Sign_In_Activity.this, R.anim.fadein);
                facebook.startAnimation(animation);
            }
        });
        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Sign_In_Activity.this, R.anim.blink_anim);
                googleplus.startAnimation(animation);
            }
        });
        Animation animation = AnimationUtils.loadAnimation(Sign_In_Activity.this, R.anim.lefttoright);
        loginLogo.startAnimation(animation);

    }
}