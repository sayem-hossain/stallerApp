package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AttendanceActivity extends AppCompatActivity {

   // MeowBottomNavigation bottomNavigation;
   ImageButton Imgbutton;
   ImageView AniImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        getSupportActionBar().hide();




        Imgbutton = findViewById(R.id.attenButton);

        AniImg = findViewById(R.id.aniImg);
        AniImg.setVisibility(View.INVISIBLE);
        Imgbutton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AttendanceActivity.this, "Successful Entry", Toast.LENGTH_SHORT).show();
                AniImg.setVisibility(View.VISIBLE);

                YoYo.with(Techniques.FadeIn).duration(1000).repeat(0).playOn(AniImg);

                return false;

            }
        });


//        bottomNavigation =  findViewById(R.id.bottom_navigation);
//
//        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_notifications));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_home));
//        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_info));
//
//
//        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
//            @Override
//            public void onShowItem(MeowBottomNavigation.Model item) {
//                Fragment fragment = null;
//               // Activity activity = null;
//
//                switch (item.getId()){
//                    case 1:
//                        fragment =  new NotificationFragment();
//                        break;
//                    case 2:
//                        fragment = new HomeFragment();
//                        break;
//                    case 3:
//                        fragment = new AboutFragment();
//                        break;
//                }
//                loadFragment(fragment);
//            }
//        });
//
//
//        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
//            @Override
//            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "You Clicked" + item.getId(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
//            @Override
//            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "You Reselected "+item.getId(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void loadFragment(Fragment fragment) {
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.frame_layout,fragment)
//                .commit();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                ,DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                       return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                ,AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}