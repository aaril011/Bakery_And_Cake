package com.ecommerce.bakeryandcake;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailCake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cake);

        ImageView photo = findViewById(R.id.imgDetail);
        TextView name = findViewById(R.id.DetailName);
        TextView price = findViewById(R.id.DetailPrice);
        TextView desc = findViewById(R.id.DetailDesc);

        Bundle bundle = getIntent().getExtras();
        photo.setImageResource(bundle.getInt("photo"));
        name.setText(bundle.getString("name"));
        price.setText(bundle.getString("price"));
        desc.setText(bundle.getString("desc"));
    }
}
