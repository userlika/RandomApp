package com.likabarken.randomapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class YesNoActivity extends AppCompatActivity {
    TextView textViewRandomYesNo;
    Button buttonAnswer;
    private String yes, no, maybe;

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

        initViews();

        String[] options = {yes, no, maybe};
        Random randomIndex = new Random();
        int randomIntRange = randomIndex.nextInt(3);

        textViewRandomYesNo.setText(options[randomIntRange]);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomIntRange = randomIndex.nextInt(3);
                textViewRandomYesNo.setText(options[randomIntRange]);
                textViewRandomYesNo.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initViews() {
        textViewRandomYesNo = findViewById(R.id.textViewRandomYesNo);
        buttonAnswer = findViewById(R.id.buttonAnswer);
        yes = getString(R.string.yes);
        no = getString(R.string.no);
        maybe = getString(R.string.maybe);
    }
}