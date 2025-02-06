package com.likabarken.randomapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class YesNoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yes_no);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] options = {"Yes", "No", "Maybe"};
        Random randomIndex = new Random();
        int randomIntRange = randomIndex.nextInt(3);

        TextView textViewRandomYesNo = findViewById(R.id.textViewRandomYesNo);

        textViewRandomYesNo.setText(options[randomIntRange]);

        textViewRandomYesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomIntRange = randomIndex.nextInt(3);
                textViewRandomYesNo.setText(options[randomIntRange]);
            }
        });

    }
}