package com.likabarken.randomapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    Random rand = new Random();
    ImageView imageViewDice1, imageViewDice2, imageViewDice3, imageViewDice4, imageViewDice5, imageViewDice6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageViewDice1 = findViewById(R.id.imageViewDice1);
        imageViewDice2 = findViewById(R.id.imageViewDice2);
        imageViewDice3 = findViewById(R.id.imageViewDice3);
        imageViewDice4 = findViewById(R.id.imageViewDice4);
        imageViewDice5 = findViewById(R.id.imageViewDice5);
        imageViewDice6 = findViewById(R.id.imageViewDice6);

        int dice_number = rand.nextInt(6) + 1;
        switch (dice_number) {
            case 1:
                imageViewDice1.setVisibility(View.VISIBLE);
                break;
            case 2:
                imageViewDice2.setVisibility(View.VISIBLE);
                break;
            case 3:
                imageViewDice3.setVisibility(View.VISIBLE);
                break;
            case 4:
                imageViewDice4.setVisibility(View.VISIBLE);
                break;
            case 5:
                imageViewDice5.setVisibility(View.VISIBLE);
                break;
            case 6:
                imageViewDice6.setVisibility(View.VISIBLE);
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }
}