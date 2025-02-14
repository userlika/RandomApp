package com.likabarken.randomapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SpinTheBottleActivity extends AppCompatActivity {
    ImageView imageViewBottle;
    private final int[] rotationAngles = {0, 45, 90, 135, 180, 225, 270, 315};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spin_the_bottle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageViewBottle = findViewById(R.id.imageViewBottle);
        rotateBottleRandomly();
    }

    private void rotateBottleRandomly() {
        Random random = new Random();
        int randomIndex = random.nextInt(rotationAngles.length);
        int selectedAngle = rotationAngles[randomIndex];

        imageViewBottle.setRotation(selectedAngle);
    }
}