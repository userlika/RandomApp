package com.likabarken.randomapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class HeadsAndTailsActivity extends AppCompatActivity {
    private static final String TAG = "HeadsAndTailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_heads_and_tails);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random randomInt = new Random();
        int oneOrTwo = randomInt.nextInt(2);

        ImageView imageViewHeads = findViewById(R.id.imageViewCoinHeads);
        ImageView imageViewTails = findViewById(R.id.imageViewCoinTails);

        if (oneOrTwo == 0) {
            imageViewHeads.setVisibility(View.VISIBLE);
            imageViewTails.setVisibility(View.INVISIBLE);
            Log.d(TAG, "The random value is heads.");
        } else if (oneOrTwo == 1) {
            imageViewTails.setVisibility(View.VISIBLE);
            imageViewHeads.setVisibility(View.INVISIBLE);
            Log.d(TAG, "The random value is tails.");
        }
        else{
            Log.d(TAG, "The random value is out of range.");
        }


    }
}