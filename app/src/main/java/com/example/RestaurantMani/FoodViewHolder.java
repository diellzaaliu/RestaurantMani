package com.example.RestaurantMani;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodViewHolder {
    ImageView imgFood;
    TextView foodDesc;

    public FoodViewHolder(View v){
        imgFood = v.findViewById(R.id.imgFood);
        foodDesc = v.findViewById(R.id.foodDesc);
    }

    public ImageView getImgFood() {
        return imgFood;
    }

    public TextView getFoodDesc() {
        return foodDesc;
    }
}
