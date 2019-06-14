package com.example.remotepayment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartInformation extends AppCompatActivity {
    private Cart cart;

    private void getNumbers() {
        Intent intent = getIntent();

        int apple_num = intent.getIntExtra("apple", 0);
        int pear_num = intent.getIntExtra("pear", 0);
        int banana_num = intent.getIntExtra("banana", 0);
        int watermelon_num = intent.getIntExtra("watermelon", 0);

        Goods apple = new Goods("apple", 2.0, apple_num);
        Goods pear = new Goods("pear", 1.5, pear_num);
        Goods banana = new Goods("banana", 3.0, banana_num);
        Goods watermelon = new Goods("watermelon", 10.0, watermelon_num);

        ArrayList<Goods> goods = new ArrayList<>();
        goods.add(apple);
        goods.add(pear);
        goods.add(banana);
        goods.add(watermelon);

        cart = new Cart(goods);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showCartInfo() {
        int counter = 1;
        double total = 0;

        ImageView fruit_image;
        TextView price;
        TextView amount;
        TextView kind_total_price;

        for (Goods good : cart.getGoods()) {
            if (good.getAmount() == 0)
                // No such goods
                continue;

            if (counter == 1) {
                fruit_image = findViewById(R.id.imageView_first);
                price = findViewById(R.id.textView_first);
                amount = findViewById(R.id.textView_amount_first);
                kind_total_price = findViewById(R.id.textView_price_first);
            }
            else if (counter == 2) {
                fruit_image = findViewById(R.id.imageView_second);
                price = findViewById(R.id.textView_second);
                amount = findViewById(R.id.textView_amount_second);
                kind_total_price = findViewById(R.id.textView_price_second);
            }
            else if (counter == 3) {
                fruit_image = findViewById(R.id.imageView_third);
                price = findViewById(R.id.textView_third);
                amount = findViewById(R.id.textView_amount_third);
                kind_total_price = findViewById(R.id.textView_price_third);
            }
            else {
                fruit_image = findViewById(R.id.imageView_fourth);
                price = findViewById(R.id.textView_fourth);
                amount = findViewById(R.id.textView_amount_fourth);
                kind_total_price = findViewById(R.id.textView_price_fourth);
            }

            if (good.getName().equals("apple"))
                fruit_image.setImageDrawable(getDrawable(R.mipmap.apple));
            else if (good.getName().equals("pear"))
                fruit_image.setImageDrawable(getDrawable(R.mipmap.pear));
            else if (good.getName().equals("banana"))
                fruit_image.setImageDrawable(getDrawable(R.mipmap.banana));
            else
                fruit_image.setImageDrawable(getDrawable(R.mipmap.watermelon));

            price.setText(Double.valueOf(good.getPrice()).toString());
            amount.setText(String.valueOf(good.getAmount()));
            kind_total_price.setText(Double.valueOf(good.getTotalPrice()).toString());

            // Increment the counter, update total
            counter += 1;
            total += good.getTotalPrice();
        }

        TextView total_price = findViewById(R.id.textView_total_price);
        total_price.setText(Double.valueOf(total).toString());
    }

    private void initReturnButton() {
        Button button = findViewById(R.id.retButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initTransferButton() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        // Init the system
        getNumbers();
        showCartInfo();
        initReturnButton();
        initTransferButton();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_information);
    }
}
