package com.sharif.instagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sharif.instagram.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView CameraToolbar = toolbar.findViewById(R.id.camera);
        CameraToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

       navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               if(item.getItemId()==R.id.navigation_home){
                   HomeFragment homeFragment = new HomeFragment();
                   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                   transaction.replace(R.id.nav_host_fragment,homeFragment);
                   transaction.commit();
               }
               else if(item.getItemId()==R.id.search){
                   Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
               }
               else if(item.getItemId()==R.id.plus){
                   Toast.makeText(MainActivity.this, "Plus", Toast.LENGTH_SHORT).show();
               }
               else if(item.getItemId()==R.id.heart){
                   Toast.makeText(MainActivity.this, "Love", Toast.LENGTH_SHORT).show();
               }
               else if(item.getItemId()==R.id.profile){
                   Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
               }

               return true;
           }
       });

    }

}