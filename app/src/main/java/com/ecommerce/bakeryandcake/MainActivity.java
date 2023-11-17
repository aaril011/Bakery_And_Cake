package com.ecommerce.bakeryandcake;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectfragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home){
                    selectfragment = new HomeFragment();
                } else if (itemId == R.id.nav_cake) {
                    selectfragment = new CakeFragment();
                } else if (itemId == R.id.nav_about) {
                    selectfragment = new AboutFragment();
                }

                if (selectfragment != null){
                    switchFragment (selectfragment);
                    return true;
                }
                return false;
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//                return true;
            }

            private void switchFragment(Fragment fragment) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                        .commit();
            }
        });
    }

}