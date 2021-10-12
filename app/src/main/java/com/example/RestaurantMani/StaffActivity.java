package com.example.RestaurantMani;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.RestaurantMani.databinding.ActivityStaffBinding;

public class StaffActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button applyTextButton;
    private Button saveButton;
    private Switch switch1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    private String text;
    private boolean switchOnOff;

    LinearLayout mainLayout;

    private AppBarConfiguration appBarConfiguration;
    private ActivityStaffBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.edittext);
        applyTextButton = (Button) findViewById(R.id.apply_text_button);
        saveButton = (Button) findViewById(R.id.save_button);
        switch1 = (Switch) findViewById(R.id.switch1);
        mainLayout = findViewById(R.id.mainLayout);

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadData();
        updateViews();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply();

        //Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        Snackbar.make(mainLayout,"Data Saved", Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setActionTextColor(getResources().getColor(R.color.common_google_signin_btn_text_dark))
                .show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);

    }

    public void updateViews() {
        textView.setText(text);
        switch1.setChecked(switchOnOff);
    }
}





