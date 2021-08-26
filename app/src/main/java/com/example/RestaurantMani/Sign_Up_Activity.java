package com.example.RestaurantMani;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class Sign_Up_Activity extends AppCompatActivity {



    EditText email, password, cpassword;
    TextView alreadyHaveAccount,profilePic;
    Button registerBtn;
    DBHelper myDB;
    private ImageView profilepicture;
    private Uri imageUri;
    private FirebaseStorage storage;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        profilePic = findViewById(R.id.profilePic);
        profilepicture = findViewById(R.id.profilepicture);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();

            }
        });


        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        cpassword = (EditText)findViewById(R.id.cpassword);
        alreadyHaveAccount = (TextView) findViewById(R.id.alreadyHaveAccount);
        registerBtn = (Button)findViewById(R.id.registerBtn);

        myDB = new DBHelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaili = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = cpassword.getText().toString();

                if (emaili.equals("") || pass.equals("") || cpass.equals("")) {
                    Toast.makeText(Sign_Up_Activity.this, "Fill All The Fields", Toast.LENGTH_SHORT).show();
                } else {


                    if(emaili.endsWith("@gmail.com") == false){
                        Toast.makeText(Sign_Up_Activity.this, "Email incorrect.Please try again!", Toast.LENGTH_SHORT).show();
                    }

                    else if(pass.equals(cpass)){
                        Boolean checkEmail = myDB.checkEmail(emaili);
                        if(checkEmail==true){
                            Boolean insert = myDB.insertData(emaili,pass);
                            if(insert==true){
                                Toast.makeText(Sign_Up_Activity.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Sign_Up_Activity.this, FoodActivity.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(Sign_Up_Activity.this, "Email Already Exists.", Toast.LENGTH_SHORT).show();
                        }
                    }else if(pass.equals(cpass)==false){
                        Toast.makeText(Sign_Up_Activity.this, "Password does not match.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_Up_Activity.this, Sign_In_Activity.class);
                startActivity(intent);
            }
        });


        }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            profilepicture.setImageURI(imageUri);
            uploadPicture();
        }
    }

    private void uploadPicture() {

        final String randomKey = UUID.randomUUID().toString();
        // Create a reference to "mountains.jpg"
        StorageReference mountainsRef = storageReference.child("images/"+randomKey);

// Create a reference to 'images/mountains.jpg'
        StorageReference mountainImagesRef = storageReference.child("images/"+randomKey);

// While the file names are the same, the references point to different files
        mountainsRef.getName().equals(mountainImagesRef.getName());    // true
        mountainsRef.getPath().equals(mountainImagesRef.getPath());    // false
    }
}
