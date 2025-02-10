package com.likabarken.randomapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RandomNumberActivity extends AppCompatActivity {
    private static final String TAG = "RandomNumberActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_number);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random rand = new Random();

        EditText editTextFrom = findViewById(R.id.editTextNumberFrom);
        EditText editTextTo = findViewById(R.id.editTextNumberTo);

        Button btnGenerateNumber = findViewById(R.id.buttonGenerateNumber);

        TextView textViewTheNumber = findViewById(R.id.textViewTheNumber);

        btnGenerateNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from_str, to_str;
                int randInt, from, to;

                from_str = editTextFrom.getText().toString().trim();
                to_str = editTextTo.getText().toString().trim();
                Log.d(TAG, "From:" + from_str);
                Log.d(TAG, "To:" + to_str);

                try {
                    from = Integer.parseInt(from_str);
                    to = Integer.parseInt(to_str);

                    // Ensure "from" is less than "to"
                    if (from >= to) {
                        textViewTheNumber.setText("Invalid range: 'From' must be less than 'To'");
                        return;
                    }

                    // Generate a random number in the range [from, to]
                    randInt = rand.nextInt(to - from + 1) + from;
                    Log.d(TAG, "randInt:" + randInt);

                    textViewTheNumber.setText(String.valueOf(randInt));
                } catch (NumberFormatException e) {
                    // Handle invalid input (non-numeric values)
                    textViewTheNumber.setText("Invalid input: Please enter valid numbers");
                } catch (IllegalArgumentException e) {
                    // Handle other unexpected errors
                    textViewTheNumber.setText("Error: Invalid range");
                }

            }
        });
    }
}