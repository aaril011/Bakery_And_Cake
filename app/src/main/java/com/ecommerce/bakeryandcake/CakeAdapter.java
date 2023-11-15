package com.ecommerce.bakeryandcake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CakeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cake> cake;

    public void setCake(ArrayList<Cake> cake) {
        this.cake = cake;
    }
    public CakeAdapter(Context context){
        this.context = context;
        cake = new ArrayList<>();
    }

    @Override
    public int getCount() {return cake.size();}

    @Override
    public Object getItem(int i) {return cake.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_cake,
                    viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Cake cake = (Cake) getItem(i);
        viewHolder.bind(cake);
        return view;
    }
    private class ViewHolder{
        private TextView txtName;
        private TextView txtPrice;
        private TextView txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtPrice = view.findViewById(R.id.txt_price);
            txtDesc = view.findViewById(R.id.txt_desc);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Cake cake){
            txtName.setText(cake.getName());
            txtPrice.setText(cake.getPrice());
            txtDesc.setText(cake.getDesc());
            imgPhoto.setImageResource (cake.getPhoto());
        }
    }
}
