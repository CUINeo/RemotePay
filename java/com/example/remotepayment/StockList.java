package com.example.remotepayment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class StockList extends AppCompatActivity {
    private void initArrows() {
        ImageButton button;

        // Arrows for apple
        button = findViewById(R.id.imageButton_apple_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment apple number
                TextView textView = findViewById(R.id.textView_apple);
                int apple_num = Integer.valueOf(textView.getText().toString());
                textView.setText(String.valueOf(++apple_num));
            }
        });

        button = findViewById(R.id.imageButton_apple_down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement apple number
                TextView textView = findViewById(R.id.textView_apple);
                int apple_num = Integer.valueOf(textView.getText().toString());

                if (apple_num > 0)
                    textView.setText(String.valueOf(--apple_num));
            }
        });

        // Arrows for pear
        button = findViewById(R.id.imageButton_pear_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment pear number
                TextView textView = findViewById(R.id.textView_pear);
                int pear_num = Integer.valueOf(textView.getText().toString());
                textView.setText(String.valueOf(++pear_num));
            }
        });

        button = findViewById(R.id.imageButton_pear_down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement pear number
                TextView textView = findViewById(R.id.textView_pear);
                int pear_num = Integer.valueOf(textView.getText().toString());

                if (pear_num > 0)
                    textView.setText(String.valueOf(--pear_num));
            }
        });

        // Arrows for banana
        button = findViewById(R.id.imageButton_banana_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment banana number
                TextView textView = findViewById(R.id.textView_banana);
                int banana_num = Integer.valueOf(textView.getText().toString());
                textView.setText(String.valueOf(++banana_num));
            }
        });

        button = findViewById(R.id.imageButton_banana_down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement banana number
                TextView textView = findViewById(R.id.textView_banana);
                int banana_num = Integer.valueOf(textView.getText().toString());

                if (banana_num > 0)
                    textView.setText(String.valueOf(--banana_num));
            }
        });

        // Arrows for watermelon
        button = findViewById(R.id.imageButton_watermelon_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment watermelon number
                TextView textView = findViewById(R.id.textView_watermelon);
                int watermelon_num = Integer.valueOf(textView.getText().toString());
                textView.setText(String.valueOf(++watermelon_num));
            }
        });

        button = findViewById(R.id.imageButton_watermelon_down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement watermelon number
                TextView textView = findViewById(R.id.textView_watermelon);
                int watermelon_num = Integer.valueOf(textView.getText().toString());

                if (watermelon_num > 0)
                    textView.setText(String.valueOf(--watermelon_num));
            }
        });
    }

    private void initButton() {
        Button button = findViewById(R.id.retButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate the cart and switch to it
                TextView textView;

                textView = findViewById(R.id.textView_apple);
                int apple_num = Integer.valueOf(textView.getText().toString());

                textView = findViewById(R.id.textView_pear);
                int pear_num = Integer.valueOf(textView.getText().toString());

                textView = findViewById(R.id.textView_banana);
                int banana_num = Integer.valueOf(textView.getText().toString());

                textView = findViewById(R.id.textView_watermelon);
                int watermelon_num = Integer.valueOf(textView.getText().toString());

                Intent intent = new Intent(StockList.this, CartInformation.class);

                intent.putExtra("apple", apple_num);
                intent.putExtra("pear", pear_num);
                intent.putExtra("banana", banana_num);
                intent.putExtra("watermelon", watermelon_num);

                startActivity(intent);
            }
        });
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        // Init the system
        initArrows();
        initButton();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_list);
    }
}
