package com.example.jemmy.babyapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.jemmy.babyapp.fragment.ActivitiesFragment;
import com.example.jemmy.babyapp.fragment.ForumFragment;
import com.example.jemmy.babyapp.fragment.HomeFragment;
import com.example.jemmy.babyapp.fragment.PanduanFragment;
import com.example.jemmy.babyapp.fragment.PerkembanganBayiFragment;
import com.example.jemmy.babyapp.fragment.SplashFragment;
import com.example.jemmy.babyapp.fragment.ToolsFragment;

public class MainActivity extends BaseActivity {

    private String TAG = "MainActivity";
    private static final String HOME_CONTENT = "HOME_CONTENT";
    private static final String PANDUAN_CONTENT = "PANDUAN_CONTENT";
    private static final String TOOLS_CONTENT = "TOOLS_CONTENT";
    private static final String FORUM_CONTENT = "FORUM_CONTENT";

    private static final String PERKEMBANGAN_KONTENT= "PERKEMBANGAN_CONTENT";
    private static final String ACTIVITIES_KONTENT= "ACTIVITIES_KONTENT";

    private FragmentTransaction transaction;

    private static boolean initActivity = true;

    private FrameLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContent = findViewById(R.id.dynamicContent);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                transaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
//                        intent = new Intent(MainActivity.this, MainActivity.class);
//                        startActivity(intent);
                        transaction.replace(R.id.dynamicContent, new HomeFragment(), HOME_CONTENT);
                        break;
                    case R.id.navigation_panduan:
//                        intent = new Intent(MainActivity.this, PanduanActivity.class);
//                        startActivity(intent);
                        transaction.replace(R.id.dynamicContent, new PanduanFragment(), PANDUAN_CONTENT);
                        break;
                    case R.id.navigation_tools:
//                        intent = new Intent(MainActivity.this, PanduanActivity.class);
//                        startActivity(intent);
                        transaction.replace(R.id.dynamicContent, new ToolsFragment(), TOOLS_CONTENT);
                        break;
                    case R.id.navigation_forum:
//                        intent = new Intent(MainActivity.this, PanduanActivity.class);
//                        startActivity(intent);
                        transaction.replace(R.id.dynamicContent, new ForumFragment(), FORUM_CONTENT);
                        break;
                }
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();
                return true;
            }        });
        if(initActivity){
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }

    }

    public void changeToPerkembangan(){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dynamicContent, new PerkembanganBayiFragment(), PERKEMBANGAN_KONTENT);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    public void changeToActivities(){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dynamicContent, new ActivitiesFragment(), PERKEMBANGAN_KONTENT);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }


}
