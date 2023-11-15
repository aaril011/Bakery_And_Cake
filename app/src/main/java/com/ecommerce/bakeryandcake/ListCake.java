package com.ecommerce.bakeryandcake;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListCake extends AppCompatActivity {
    private String[] cake_name;
    private String[] cake_price;
    private String[] cake_desc;
    private TypedArray cake_photo;
    private CakeAdapter adapter;
    private ArrayList<Cake> cakelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_cake);
        adapter = new CakeAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cake list = cakelist.get(i);
                Intent intent = new Intent(ListCake.this, DetailCake.class);
                intent.putExtra("name", list.getName());
                intent.putExtra("price", list.getPrice());
                intent.putExtra("desc", list.getDesc());
                intent.putExtra("photo", list.getPhoto());
                startActivity(intent);
            }
        });

    }
    private void prepare() {
        cake_name =
                getResources().getStringArray(R.array.cake_name);
        cake_price =
                getResources().getStringArray(R.array.cake_price);
        cake_desc =
                getResources().getStringArray(R.array.cake_desc);
        cake_photo =
                getResources().obtainTypedArray(R.array.cake_photo);
    }
    private void addItem() {
        cakelist = new ArrayList<>();
        for (int i = 0; i < cake_name.length; i++) {
            Cake cake = new Cake();
            cake.setPhoto(cake_photo.getResourceId(i, -1));
            cake.setName(cake_name[i]);
            cake.setPrice(cake_price[i]);
            cake.setDesc(cake_desc[i]);
            cakelist.add(cake);
        }
        adapter.setCake(cakelist);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Search Cake..");
        return true;
    }
}
