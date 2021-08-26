package com.example.RestaurantMani;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FoodActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FoodAdapter foodAdapter;
    ListView lvFood;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        navigationView.bringToFront();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        lvFood = findViewById(R.id.lvFood);

        foodAdapter = new FoodAdapter(FoodActivity.this);
        foodAdapter.dataSource.setResponse("true");
        foodAdapter.dataSource.setTotalResults("8");

        foodAdapter.dataSource.getCategory().add(new Category("APPETIZER", "https://images.squarespace-cdn.com/content/v1/5f58dcab66bbca192c9f937f/1604664074079-FTEB0A8RVUHRYRWJ3AHK/ke17ZwdGBToddI8pDm48kGPVK--wGoWXJsqwlxbZlQN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mwONMR1ELp49Lyc52iWr5enfxu_O4VeONvneR-F6W8oeFhFqSrYyNrfPB9Y70_gvQ/ahi+1.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("SOUP", "https://images.squarespace-cdn.com/content/v1/5f58dcab66bbca192c9f937f/1610345894880-4U2V1MMPA450JF0G9QB8/ke17ZwdGBToddI8pDm48kGPVK--wGoWXJsqwlxbZlQN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mwONMR1ELp49Lyc52iWr5enfxu_O4VeONvneR-F6W8oeFhFqSrYyNrfPB9Y70_gvQ/soup+1.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("SALADS", "https://images.squarespace-cdn.com/content/v1/5f58dcab66bbca192c9f937f/1619703572052-0KF132YFENN9TA86AM45/ke17ZwdGBToddI8pDm48kDId7IVMtP3dulcRU2cAgIx7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UXWCsysSeV8cJ0kwnD8huENc19wYMq9r3sX_aixKqN5jlzlwDjT8OAOS9F-OY2Zmdw/DSC_5850.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("PIZZA", "http://www.picadostava.rs/wp-content/uploads/2017/01/bg-pizza.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("FAST FOOD", "https://prod-wolt-venue-images-cdn.wolt.com/605c5a80961bf0ac60dded61/18053b06-8d4f-11eb-a4b9-a2e389135340_fastfoodsalara_listmenu_stari_sps_006.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("ENTREES", "https://images.squarespace-cdn.com/content/v1/5f58dcab66bbca192c9f937f/1619700764617-QSAUU827YBUWGL2QDAWP/ke17ZwdGBToddI8pDm48kGPVK--wGoWXJsqwlxbZlQN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mwONMR1ELp49Lyc52iWr5enfxu_O4VeONvneR-F6W8oeFhFqSrYyNrfPB9Y70_gvQ/DSC_5453.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("PASTA", "https://wallpaperaccess.com/full/1463534.jpg"));
        foodAdapter.dataSource.getCategory().add(new Category("DESSERTS", "https://images.squarespace-cdn.com/content/v1/5f58dcab66bbca192c9f937f/1619701701687-IRSBQUJ8DKWGBC6RK5VU/ke17ZwdGBToddI8pDm48kGPVK--wGoWXJsqwlxbZlQN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mwONMR1ELp49Lyc52iWr5enfxu_O4VeONvneR-F6W8oeFhFqSrYyNrfPB9Y70_gvQ/DSC_5964.jpg"));


        lvFood.setAdapter(foodAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_appetizer:
                Intent intent = new Intent(FoodActivity.this,AppetizerActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_soup:
                Intent intent1 = new Intent(FoodActivity.this,SoupActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_salads:
                Intent intent2 = new Intent(FoodActivity.this,SaladsActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_pizza:
                Intent intent3 = new Intent(FoodActivity.this,PizzaActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_qaRate:
                Intent intent4 = new Intent(FoodActivity.this,QandA_Rate_Activity.class);
                startActivity(intent4);
                break;
            case R.id.nav_location:
                Intent intent5 = new Intent(FoodActivity.this,LocationActivity.class);
                startActivity(intent5);
                break;

        }

        return true;
    }
}