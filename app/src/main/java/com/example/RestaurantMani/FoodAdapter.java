package com.example.RestaurantMani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

public class FoodAdapter extends BaseAdapter {

    Context c;
    public FoodModel dataSource = new FoodModel();
    public FoodAdapter(Context _c){
        c = _c;
    }

    @Override
    public int getCount() {
        return Integer.parseInt(dataSource.getTotalResults());
    }

    @Override
    public Object getItem(int position) {
        return dataSource.getCategory().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(c).inflate(R.layout.food_row_layout,parent,false);
            viewHolder = new FoodViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (FoodViewHolder) convertView.getTag();
        }
        viewHolder.foodDesc.setText(dataSource.getCategory().get(position).getName());
        Picasso.get().load(dataSource.getCategory().get(position).getImage()).into(viewHolder.imgFood);
        return convertView;
    }
}
