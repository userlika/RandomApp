package com.likabarken.randomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textViewOptionYesNo = findViewById(R.id.textViewOptionYesNo);
        TextView textViewOptionHeadsAndTails = findViewById(R.id.textViewOptionHeadsAndTails);

        textViewOptionYesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNextScreen(MainActivity.this, YesNoActivity.class);

            }
        });

        textViewOptionHeadsAndTails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNextScreen(MainActivity.this, HeadsAndTailsActivity.class);

            }
        });

    }
    private void launchNextScreen(AppCompatActivity currentActivity, Class<? extends AppCompatActivity> nextActivityClass) {
        Intent intent = new Intent(currentActivity, nextActivityClass);
        currentActivity.startActivity(intent);
    }
}